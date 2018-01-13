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
import org.tensoft.gaoxiao.utils.JsonUtil;
import org.tensoft.gaoxiao.vo.BootstrapTableResult;
import org.tensoft.gaoxiao.vo.Pager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/role/")
public class TbRoleController {

	@Autowired
	TbRoleService tbRoleService;
	
	@RequestMapping("list")
	@ResponseBody
	public BootstrapTableResult<TbRole> getall(String gridPager){
		BootstrapTableResult <TbRole> result = new BootstrapTableResult<>();
		try {
			Pager pager = JsonUtil.getObjectFromJson(gridPager, Pager.class);
			Map<String, Object> parameters =null;
			if (pager.getParameters()==null) {
				parameters = new HashMap<>();
			}else {
				parameters = pager.getParameters();
			}
			if (parameters.get("parentId")==null) {
				parameters.put("s_parent_id", 0);
			}else{
				parameters.put("s_parent_id", parameters.get("parentId"));
			}
			Page<Object> pagelist = PageHelper.startPage(pager.getNowPage(), pager.getPageSize(), true);
		List<TbRole>list = 	tbRoleService.getlist(parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
