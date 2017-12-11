package org.tensoft.gaoxiao.model;

import java.io.Serializable;

/**
 * <p>
 * 公司表 组织表
 * </p>
 *
 * @author xj
 * @since 2017-05-08
 */
public class TbDept implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3125781562323348104L;
	private Integer id;
	private Integer pid;
	private String pids;
	
	private String name;
	private String fullname;
	private String tips;
	
	private String pname;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

}
