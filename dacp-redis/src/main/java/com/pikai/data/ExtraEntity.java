package com.pikai.data;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * 公共属性基类
 *
 * @author jack
 */
public abstract class ExtraEntity {
    private static final long serialVersionUID = 2498902831272177631L;
    protected Long createId;
    protected Date createTime;
    protected Long updateId;
    protected Date updateTime;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static abstract interface Update {
    }

    public static abstract interface Save {
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isEmptyString(Object s) {
        return (s == null) || (s.toString().trim().length() == 0) || s.toString().trim().equalsIgnoreCase("null");
    }

    /**
     * 获取创建时间的时间串 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public String getCreateTimeStr() {
        return this.createTime != null ? new DateTime(this.createTime).toString("yyyy-MM-dd HH:mm:ss") : null;
    }
}