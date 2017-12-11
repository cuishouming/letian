package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;



/**
 * <p>
 * 用户角色映射表
 * </p>
 *
 * @author xj
 * @since 2016-12-26
 */
public class TbRoleUser implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1891160906293038917L;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 角色id
	 */
	private Integer rId;
	/**
	 * 用户id
	 */
	private Integer uId;
	/**
	 * 创建时间
	 */
	private Date tCreateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRId() {
		return rId;
	}

	public void setRId(Integer rId) {
		this.rId = rId;
	}

	public Integer getUId() {
		return uId;
	}

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Date getTCreateTime() {
		return tCreateTime;
	}

	public void setTCreateTime(Date tCreateTime) {
		this.tCreateTime = tCreateTime;
	}

	
	public TbRoleUser(Integer uId) {
		super();
		this.uId = uId;
	}

	
	public TbRoleUser() {
		super();
	}

	

}
