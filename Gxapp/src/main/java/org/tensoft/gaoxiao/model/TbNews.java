package org.tensoft.gaoxiao.model;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 栏目管理
 * </p>
 *
 * @author xj
 * @since 2017-01-05
 */
public class TbNews implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4650645111740915100L;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer navId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 关键词
	 */
	private String keyWords;
	/**
	 * 封面图
	 */
	private String coverImg;
	/**
	 * 是否显示  1是  2否
	 */
	private String isShow;
	/**
	 * 
	 */
	private String descs;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String createUser;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private String updateUser;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNavId() {
		return navId;
	}

	public void setNavId(Integer navId) {
		this.navId = navId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	
}

