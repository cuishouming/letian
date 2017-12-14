package org.tensoft.gaoxiao.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.vo.AjaxResult;

public abstract class BaseController {
	
	/**
	 * 获取登录用户信息
	 * @return
	 */
	public TbUser getUserEntity() {
		return (TbUser)SecurityUtils.getSubject().getPrincipal();
	}
	
	
	/**
	 * 成功,返回状态
	 * @param <T>
	 * @return
	 */
	public  AjaxResult success() {
		AjaxResult result = new AjaxResult();
		result.setStatusCode(AjaxResult.STATUS_CODE_OK);
		result.setMessage("操作成功");
		return result;
	}
	public  AjaxResult success(Object obj) {
		AjaxResult result = new AjaxResult();
		result.setStatusCode(AjaxResult.STATUS_CODE_OK);
		result.setMessage("操作成功");
		result.setData(obj);
		return result;
	}
	
	public  AjaxResult success(Map<String,Object> map) {
		AjaxResult result = new AjaxResult();
		result.setStatusCode(AjaxResult.STATUS_CODE_OK);
		result.setMessage("操作成功");
		result.setMap(map);
		return result;
	}
	/**
	 * 失败,返回状态
	 * @param message 消息
	 * @return
	 */
	public  AjaxResult fail() {
		AjaxResult result = new AjaxResult();
		result.setStatusCode(AjaxResult.STATUS_CODE_ERROE);
		result.setMessage("操作失败");
		return result;
	}
	
	
}
