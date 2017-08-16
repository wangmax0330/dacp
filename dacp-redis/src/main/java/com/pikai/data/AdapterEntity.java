package com.pikai.data;

import java.util.Set;

public class AdapterEntity implements java.io.Serializable, Cloneable {
    public Object getSort() {
        return sort;
    }

    public void setSort(Object sort) {
        this.sort = sort;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Set<Long> getItemselector() {
        return Itemselector;
    }

    public void setItemselector(Set<Long> itemselector) {
        Itemselector = itemselector;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    protected java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
    /**
     *
     */
    private static final long serialVersionUID = -8312183615633798727L;

    private Integer page;
    private Long recordCount;
    private Integer listSize;
    private Integer pageSize;
    private Integer listItemSize;
    private Integer pageItemSize;
    private String query;
    private String filter;
    private Set<Long> ids;
    private Set<String> stringIds;
    private String orderField;
    private String orderString;
    private Integer start;
    private Integer limit;
    //extjs support
    private Set<Long> Itemselector;
    private Object sort;
    private String command;
    private String extra;
    private boolean humpToUnderline = true;//FilterHelper, sort排序时, 是否将排序字段名驼峰转下划线

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getListSize() {
        return listSize;
    }

    public void setListSize(Integer listSize) {
        this.listSize = listSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getListItemSize() {
        return listItemSize;
    }

    public void setListItemSize(Integer listItemSize) {
        this.listItemSize = listItemSize;
    }

    public Integer getPageItemSize() {
        return pageItemSize;
    }

    public void setPageItemSize(Integer pageItemSize) {
        this.pageItemSize = pageItemSize;
    }

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }

    public Set<String> getStringIds() {
        return stringIds;
    }

    public void setStringIds(Set<String> stringIds) {
        this.stringIds = stringIds;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderString() {
        return orderString;
    }

    public void setOrderString(String orderString) {
        this.orderString = orderString;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean getHumpToUnderline() {
        return humpToUnderline;
    }

    public void setHumpToUnderline(boolean humpToUnderline) {
        this.humpToUnderline = humpToUnderline;
    }
}
