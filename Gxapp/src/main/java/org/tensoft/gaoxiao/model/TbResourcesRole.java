package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;



/**
 * <p>
 * 角色权限映射表
 * </p>
 *
 * @author xj
 * @since 2016-12-27
 */
public class TbResourcesRole implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3143283010263886389L;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 资源id
	 */
	private Integer sid;
	/**
	 * 角色id
	 */
	private Integer rid;
	/**
	 * 创建时间
	 */
	private Date createTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
