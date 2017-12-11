package org.tensoft.gaoxiao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tensoft.gaoxiao.model.TbUser;
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
	
	 @RequestMapping("/listss")
	 @ResponseBody
	 public BootstrapTableResult<TbUser> findUserList(SearchModel searchModel){
		 BootstrapTableResult<TbUser> result = new BootstrapTableResult<TbUser>();
		 Page<Object> pages = PageHelper.startPage(searchModel.getLimit(),searchModel.getOffset());
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("accountName", searchModel.getS_name().trim());
		 List<TbUser> list =  tbUserService.selectUser(map);
		 result.setTotal(pages.getTotal());
		 result.setRows(list);
		
		return result;
		 
	 } 
	
}
