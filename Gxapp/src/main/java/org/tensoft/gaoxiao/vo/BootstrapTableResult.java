package org.tensoft.gaoxiao.vo;

import java.util.List;

public class BootstrapTableResult<T> extends AjaxResult{
    private Object hjxx;
    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Object getHjxx() {
        return hjxx;
    }

    public void setHjxx(Object hjxx) {
        this.hjxx = hjxx;
    }
}
