package com.jeff.datamanagesystem.dto;

public class ListParams {
    private Integer pageSize;
    private Integer currPage;
    private String sortField;
    private String sortOrder;

    public ListParams() {
    }

    public ListParams(Integer pageSize, Integer currPage, String sortField, String sortOrder) {
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "ListParams{" +
                "pageSize=" + pageSize +
                ", currPage=" + currPage +
                ", sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
