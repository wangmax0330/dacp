package com.pikai.data;

/**
 * 员工更新的自动更新
 *
 * @author cici
 */
public abstract class EmployeeAuditEntity {
    private static final long serialVersionUID = 163949452818086930L;
    protected Long updateTime;
    protected Long createTime;

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}