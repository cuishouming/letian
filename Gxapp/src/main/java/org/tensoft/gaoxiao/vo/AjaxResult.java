package org.tensoft.gaoxiao.vo;

import java.util.Map;

public class AjaxResult {
    public static final int STATUS_CODE_OK = 200;
    public static final int STATUS_CODE_ERROE = 300;
    private int statusCode;
    private String message;
    
    private Object data;
    
    private Map<String, Object> map;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
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
