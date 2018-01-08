 package org.tensoft.gaoxiao.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tensoft.gaoxiao.model.TbRole;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.TbDeptService;
import org.tensoft.gaoxiao.service.TbRoleService;
import org.tensoft.gaoxiao.service.TbUserService;
import org.tensoft.gaoxiao.utils.EndecryptUtils;
import org.tensoft.gaoxiao.vo.AjaxResult;
import org.tensoft.gaoxiao.vo.BootstrapTableResult;
import org.tensoft.gaoxiao.vo.SearchModel;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

@Controller
@RequestMapping("/user/")
public class TbUserController  extends BaseController{

	@Autowired
	TbUserService tbUserService;
	
	@Autowired
	TbRoleService tbRoleService;
	
	@Autowired
	TbDeptService tbDeptService;
	/**
	 * 获取所有的 用户信息
	 * @param searchModel 前台传过来的一些查询参数
	 * @return
	 */
	 @RequestMapping("list")
	 @ResponseBody
	 public BootstrapTableResult<TbUser> findUserList(SearchModel searchModel){
		 BootstrapTableResult<TbUser> result = new BootstrapTableResult<TbUser>();
		 try {
			 Page<Object> pages = PageHelper.startPage(searchModel.getLimit(),searchModel.getOffset());
 			 Map<String, Object> map = new HashMap<String, Object>();
			 if(StringUtil.isNotEmpty(searchModel.getS_name())){
				 map.put("uAccountName", searchModel.getS_name());
			 }
			 List<TbUser> list =  tbUserService.selectUser(map);
			 result.setTotal(pages.getTotal());
			 result.setRows(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		 
	 }
	 /**
	  * 点击添加 的操作 需要把 所有的角色信息查询出来带过去
	  * @return
	  */
	 @GetMapping("form")
	 public String toUserForm(Model model){
		 List<TbRole> roles = tbRoleService.getAll();
		 model.addAttribute("roles", roles);
		 return "user/form";
	 }
	
	// 添加时 登录名称的验证 不可以重名
		@GetMapping("checkAccount")
		@ResponseBody
	    public boolean checkAccount(@RequestParam(required=true) String uAccountName) {
			//先判断用户名是否是合法的表达式;
			String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
			if(!uAccountName.matches(regx)){
				return false;
			}
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("uAccountName", uAccountName);
			List<TbUser> userlist =tbUserService.selectUser(map);
			if(userlist.size()>0){
				return false;
			}
			return true;
	    }
		@PostMapping("saveOrupdate")
		@ResponseBody
		public AjaxResult saveOrUpdateUser(TbUser user){
			if (user.getuId()==null) {
				// 加密用户输入的密码，得到密码和加密盐，保存到数据库
				TbUser userEntity = EndecryptUtils.md5Password(user.getuAccountName(), user.getuPassword(), 2);
				//设置添加用户的密码和加密盐
				user.setuPassword(userEntity.getuPassword());
				user.setuCredentialsSalt(userEntity.getuCredentialsSalt());
				
				//设置创建者姓名
				user.setuCreatorName(getUserEntity().getuAccountName());
				user.setuCreateTime(new Date(System.currentTimeMillis()));
				user.setuUpdateTime(new Date(System.currentTimeMillis()));
				//设置锁定状态：未锁定；删除状态：未删除
				user.setuLocked(0);
				user.setuDeleteStatus(0);
				
				Boolean result = tbUserService.instertAll(user);
				if(!result){
					return fail();
				}
			} else {
					//xiugaishuju
			}
			return success();
			
		}
		/**
		 * 点击重置密码的操作
		 * @param uId
		 * @param map
		 * @return
		 */
		@GetMapping("{uId}/toRestPassword")
		public String toRepasw(@PathVariable(required=true) Integer uId,Map<String, Object> map){
			TbUser tbUser = tbUserService.get(uId);
			map.put("user", tbUser);
			return "/user/rest";
			
		}
		/**
		 * 重置密码保存的操作
		 * @param map
		 * @param tbUser
		 * @return
		 */
		@PostMapping("/restPassword")
		@ResponseBody
		public AjaxResult restPassword(Map<String, Object> map,TbUser tbUser){
			TbUser user = tbUserService.get(tbUser.getuId());
			//密码加密
			TbUser userFlag = EndecryptUtils.md5Password(tbUser.getuAccountName(), tbUser.getuPassword(), 2);
			user.setuPassword(userFlag.getuPassword());
			user.setuCredentialsSalt(userFlag.getuCredentialsSalt());
			user.setuUpdateTime(new Date(System.currentTimeMillis()));
			if( tbUserService.update(user)<0){
				return fail();
			}
			return success();
		}
		
		
		@GetMapping("{uId}/toEdit")
	    public String select(Map<String,Object> map,@PathVariable(required=true) Integer uId) {	
			TbUser user = tbUserService.get(uId);
			user.setDept(tbDeptService.get(user.getuDeptId()));
			map.put("user", user);
		//	makeCommon(map);
			return "user/edit";
	    }	
}
