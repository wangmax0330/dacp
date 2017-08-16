package com.pikai.data;

public class SysResource extends AdapterEntity {
    private static final long serialVersionUID = -4550741340400885747L;

    private Integer resourceId;

    private String type;

    private Integer menuId;

    private String name;

    private String value;

    private String remark;

    private Integer resourceSource;

    private String resourceFlage;

    private String image;

    private String formAuthority;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getResourceSource() {
        return resourceSource;
    }

    public void setResourceSource(Integer resourceSource) {
        this.resourceSource = resourceSource;
    }

    public String getResourceFlage() {
        return resourceFlage;
    }

    public void setResourceFlage(String resourceFlage) {
        this.resourceFlage = resourceFlage == null ? null : resourceFlage.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFormAuthority() {
        return formAuthority;
    }

    public void setFormAuthority(String formAuthority) {
        this.formAuthority = formAuthority == null ? null : formAuthority.trim();
    }
}