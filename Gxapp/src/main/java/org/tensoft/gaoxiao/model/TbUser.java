package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;



/**
 * <p>
 * 用户账户表
 * </p>
 *
 * @author xj
 * @since 2016-12-20
 */
public class TbUser implements Serializable{


	private static final long serialVersionUID = 2551921988221106775L;
	
	/**
	 * 用户id
	 */
	private Integer id;
	/**
	 * 真实姓名
	 */
	private String userName;
	/**
	 * 账户名称
	 */
	//@NotBlank(message = "用户名不能为空") 
	@Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})"
    		,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
	private String accountName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 逻辑删除状态
	 */
	private Integer deleteStatus;
	/**
	 * 是否锁定
	 */
	private Integer locked;
	/**
	 * 用户描述
	 */
	private String description;
	/**
	 * 加密盐
	 */
	private String credentialsSalt;
	/**
	 * 创建者
	 */
	@NotBlank(message = "用户名不能为空") 
	private String creatorName;
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
	
	private String roleId;
	private TbRole role;

	private TbDept dept;
	
	private String email;
	
	private String img;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	
	public TbRole getRole() {
		return role;
	}


	public void setRole(TbRole role) {
		this.role = role;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getDeleteStatus() {
		return deleteStatus;
	}


	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}


	public Integer getLocked() {
		return locked;
	}


	public void setLocked(Integer locked) {
		this.locked = locked;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCredentialsSalt() {
		return credentialsSalt;
	}


	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}


	public String getCreatorName() {
		return creatorName;
	}


	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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
	
	


	public TbUser(String accountName) {
		super();
		this.accountName = accountName;
	}

	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	public TbDept getDept() {
		return dept;
	}


	public void setDept(TbDept dept) {
		this.dept = dept;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public TbUser() {
		super();
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}



}
