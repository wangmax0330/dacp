package com.pikai.base;

/**
 * 项目名称：dacp
 * 包名： com.pikai.base
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/9 17:32
 */
public class BaseDomain {
    private Long id;
    private boolean delflag = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDelflag() {
        return delflag;
    }

    public void setDelflag(boolean delflag) {
        this.delflag = delflag;
    }
}
