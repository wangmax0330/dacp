package com.pikai.data;

public class KnEmployeeOrganizationKey extends AdapterEntity {
    private static final long serialVersionUID = 7881177389948943162L;
    private Long empId;

    private Long orgId;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}