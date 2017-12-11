package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 日志输出文件
 * </p>
 *
 * @author xj
 * @since 2017-01-04
 */
public class TbLoginInfo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6390898899657104368L;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String accountName;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private Date loginTime;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private String status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}

