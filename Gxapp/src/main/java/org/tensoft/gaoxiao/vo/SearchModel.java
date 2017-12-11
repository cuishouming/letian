package org.tensoft.gaoxiao.vo;

/**
 * Created by lly on 2016-08-19.
 * 公共查询
 */
public class SearchModel {
  
	private String s_name;
	private String s_starttime;
    private String s_endtime;
    private String order;
    /**
     * 跳过多少页
     */
    private int offset;
    /**
     * 当前多少页
     */
    private int limit;
    /**
     * 当前页
     */
    private int page;
    


    public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getS_starttime() {
        return s_starttime;
    }

    public void setS_starttime(String s_starttime) {
        this.s_starttime = s_starttime;
    }

    public String getS_endtime() {
        return s_endtime;
    }

    public void setS_endtime(String s_endtime) {
        this.s_endtime = s_endtime;
    }

   

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    
}
