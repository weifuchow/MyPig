package com.pig.utils.entity;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 * Created by chuangang.li on 2017/1/18.
 */
public class BaseQuery<T> {
    private int pageIndex = 0;

    private int pageSize = 20;

    private String keyword;

    private String sort;

    private boolean isAsc;

    public PageRequest getPageReq() {
        //不排序
        if (StringUtils.isEmpty(this.sort)) {
            return new PageRequest(this.pageIndex, this.pageSize);
        }
        //需要排序，通用分页只支持单字段
        return new PageRequest(this.pageIndex, this.pageSize, new Sort(this.isAsc ? Sort.Direction.ASC : Sort.Direction.DESC, this.sort));
    }

    public Specification<T> where() {
        return null;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
