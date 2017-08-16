package com.pikai.data;
public class KnEmployeePositionKey extends AdapterEntity{
    private static final long serialVersionUID=9053047289279310372L;
    private Long empId;

    private Long posId;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }
}