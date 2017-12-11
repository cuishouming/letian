package org.tensoft.gaoxiao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tensoft.gaoxiao.model.TbRole;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.TbRoleService;
import org.tensoft.gaoxiao.service.TbUserService;
import org.tensoft.gaoxiao.vo.BootstrapTableResult;
import org.tensoft.gaoxiao.vo.SearchModel;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Controller
@RequestMapping("/user")
public class TbUserController {

	@Autowired
	TbUserService tbUserService;
	
	@Autowired
	TbRoleService tbRoleService;
	/**
	 * 获取所有的 用户信息
	 * @param searchModel 前台传过来的一些查询参数
	 * @return
	 */
	 @RequestMapping("/list")
	 @ResponseBody
	 public BootstrapTableResult<TbUser> findUserList(SearchModel searchModel){
		 BootstrapTableResult<TbUser> result = new BootstrapTableResult<TbUser>();
		 try {
			 Page<Object> pages = PageHelper.startPage(searchModel.getLimit(),searchModel.getOffset());
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("accountName", searchModel.getS_name().trim());
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
	 @GetMapping("/form")
	 public String toUserForm(Model model){
		 List<TbRole> roles = tbRoleService.getAll();
		 model.addAttribute("roles", roles);
		 return "user/form";
	 }
	
}
