package com.pig.utils.entity;

import java.util.List;

/**
 * Created by chuangang.li on 2017/1/19.
 */
public class PageResult<T> {
    private long total;

    private int pageCount;

    private List<T> pageList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
