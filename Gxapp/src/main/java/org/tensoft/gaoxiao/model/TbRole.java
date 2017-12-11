package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




/**
 * <p>
 * 角色表
 * </p>
 *
 * @author xj
 * @since 2016-12-20
 */
public class TbRole implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3215918970906321965L;
	/**
	 * 角色id
	 */
	private Integer id;
	/**
	 * 角色名称
	 */
	private String rolename;
	/**
	 * 角色key
	 */
	private String rolekey;
	/**
	 * 角色状态,0：正常；1：删除
	 */
	private Integer rolestatus;
	/**
	 * 角色描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	private Integer deptId;
	
	private String deptName;
	
	private TbDept dept;

	private List<TbUser> userList;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public String getRolekey() {
		return rolekey;
	}

	public void setRolekey(String rolekey) {
		this.rolekey = rolekey;
	}

	

	public Integer getRolestatus() {
		return rolestatus;
	}

	public void setRolestatus(Integer rolestatus) {
		this.rolestatus = rolestatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<TbUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TbUser> userList) {
		this.userList = userList;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public TbDept getDept() {
		return dept;
	}

	public void setDept(TbDept dept) {
		this.dept = dept;
	}

	

}
