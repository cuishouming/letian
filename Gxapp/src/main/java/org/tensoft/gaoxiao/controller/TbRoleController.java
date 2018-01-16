package org.tensoft.gaoxiao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tensoft.gaoxiao.model.TbRole;
import org.tensoft.gaoxiao.service.TbRoleService;
import org.tensoft.gaoxiao.vo.BootstrapTableResult;
import org.tensoft.gaoxiao.vo.SearchModel;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/role/")
public class TbRoleController extends BaseController {

	@Autowired
	TbRoleService tbRoleService;
	/**
	 * 查询角色信息 如何查登陆用户所在部门的角色信息呢
	 * @param gridPager
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public BootstrapTableResult<TbRole> getall(SearchModel searchModel){
		BootstrapTableResult <TbRole> result = new BootstrapTableResult<>();
		try {
			 Page<Object> pages = PageHelper.startPage(searchModel.getLimit(),searchModel.getOffset(),true);
			Map<String, Object> parameters =new HashMap<>();;
			//获取登陆用户所在的企业id
			Integer deptId = getUserEntity().getuDeptId();
			parameters.put("deptId", deptId);
		   List<TbRole>list = 	tbRoleService.getlist(parameters);
		   result.setRows(list);
		   result.setTotal(pages.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
