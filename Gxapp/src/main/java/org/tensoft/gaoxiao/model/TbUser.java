package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	private Integer uId;

    private String uName;

    private String uAccountName;

    private String uPassword;

    private Integer uDeleteStatus;

    private Integer uLocked;

    private String uDescription;

    private String uCredentialsSalt;

    private String uCreatorName;

    private Date uCreateTime;

    private Date uUpdateTime;

    private Integer uDeptId;

    private String uImg;

    private String uEmail;
    
	
	private String deptName;
	
	private Integer roleId;
	private TbRole role;

	private TbDept dept;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAccountName() {
		return uAccountName;
	}

	public void setuAccountName(String uAccountName) {
		this.uAccountName = uAccountName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public Integer getuDeleteStatus() {
		return uDeleteStatus;
	}

	public void setuDeleteStatus(Integer uDeleteStatus) {
		this.uDeleteStatus = uDeleteStatus;
	}

	public Integer getuLocked() {
		return uLocked;
	}

	public void setuLocked(Integer uLocked) {
		this.uLocked = uLocked;
	}

	public String getuDescription() {
		return uDescription;
	}

	public void setuDescription(String uDescription) {
		this.uDescription = uDescription;
	}

	public String getuCredentialsSalt() {
		return uCredentialsSalt;
	}

	public void setuCredentialsSalt(String uCredentialsSalt) {
		this.uCredentialsSalt = uCredentialsSalt;
	}

	public String getuCreatorName() {
		return uCreatorName;
	}

	public void setuCreatorName(String uCreatorName) {
		this.uCreatorName = uCreatorName;
	}

	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	public Date getuUpdateTime() {
		return uUpdateTime;
	}

	public void setuUpdateTime(Date uUpdateTime) {
		this.uUpdateTime = uUpdateTime;
	}

	public Integer getuDeptId() {
		return uDeptId;
	}

	public void setuDeptId(Integer uDeptId) {
		this.uDeptId = uDeptId;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public TbRole getRole() {
		return role;
	}

	public void setRole(TbRole role) {
		this.role = role;
	}

	public TbDept getDept() {
		return dept;
	}

	public void setDept(TbDept dept) {
		this.dept = dept;
	}
	
	
	
}
