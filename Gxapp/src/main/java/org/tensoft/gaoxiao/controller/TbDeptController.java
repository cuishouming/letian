package org.tensoft.gaoxiao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tensoft.gaoxiao.model.TbDept;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.TbDeptService;
import org.tensoft.gaoxiao.vo.AjaxResult;

@Controller
@RequestMapping("/dept")
public class TbDeptController extends BaseController {

	@Autowired 
	TbDeptService tbDeptService;
	
	@GetMapping("listTree")
	@ResponseBody
	public AjaxResult listTree(){
		TbUser user = getUserEntity();
		//SELECT id AS id,pid,pids,simplename AS `name`,fullname,tips,version FROM tb_dept WHERE (pids LIKE ? OR id=?) 
		List<TbDept> list = tbDeptService.getAll();
		return success(list);
		
	}
}
