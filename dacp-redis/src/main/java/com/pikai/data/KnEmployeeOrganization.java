package com.pikai.data;

public class KnEmployeeOrganization extends KnEmployeeOrganizationKey {
    private static final long serialVersionUID = 5039296719030004877L;
    private Integer charge;

    private Integer major;

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }
}