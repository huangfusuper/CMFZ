package com.baizhi.dto;

import java.util.List;

public class PageDTO<T> {
    private Integer total;
    private List<T> rows;

    @Override
    public String toString() {
        return "PageDTO{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageDTO(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageDTO() {
    }
}
