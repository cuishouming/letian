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

	    private String simplename;
	    private String name;

	    private String fullname;

	    private String tips;

	    private Integer version;

	    public Integer getId() {
	        return id;
	    }

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

	    public String getPids() {
	        return pids;
	    }

	    public void setPids(String pids) {
	        this.pids = pids == null ? null : pids.trim();
	    }

	    public String getSimplename() {
	        return simplename;
	    }

	    public void setSimplename(String simplename) {
	        this.simplename = simplename == null ? null : simplename.trim();
	    }

	    public String getFullname() {
	        return fullname;
	    }

	    public void setFullname(String fullname) {
	        this.fullname = fullname == null ? null : fullname.trim();
	    }

	    public String getTips() {
	        return tips;
	    }

	    public void setTips(String tips) {
	        this.tips = tips == null ? null : tips.trim();
	    }

	    public Integer getVersion() {
	        return version;
	    }

	    public void setVersion(Integer version) {
	        this.version = version;
	    }


	

}
