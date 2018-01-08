package org.tensoft.gaoxiao.model;

import java.util.Date;
import java.util.List;


public class TbRole {
    private Integer rId;

    private String rName;

    private String rKey;

    private Integer rStatus;

    private String rDescription;

    private Date rCreateTime;

    private Date rUpdateTime;

    private Integer rDeptId;
    
    private List<TbUser> userList;

    public List<TbUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TbUser> userList) {
		this.userList = userList;
	}

	public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrKey() {
        return rKey;
    }

    public void setrKey(String rKey) {
        this.rKey = rKey == null ? null : rKey.trim();
    }

    public Integer getrStatus() {
        return rStatus;
    }

    public void setrStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }

    public Date getrCreateTime() {
        return rCreateTime;
    }

    public void setrCreateTime(Date rCreateTime) {
        this.rCreateTime = rCreateTime;
    }

    public Date getrUpdateTime() {
        return rUpdateTime;
    }

    public void setrUpdateTime(Date rUpdateTime) {
        this.rUpdateTime = rUpdateTime;
    }

    public Integer getrDeptId() {
        return rDeptId;
    }

    public void setrDeptId(Integer rDeptId) {
        this.rDeptId = rDeptId;
    }
}