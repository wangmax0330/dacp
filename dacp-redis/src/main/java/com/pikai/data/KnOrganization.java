package com.pikai.data;

import java.util.Set;

/**
 * 组织结构表
 *
 * @author chirs@zhoujin.com (Chirs Chou)
 */
public class KnOrganization extends ExtraEntity {
    private static final long serialVersionUID = -3125262430737955267L;
    private String code;//编码,没有意义
    private String name;//名称
    private String description; //描述
    private Long supId; //父节点id
    private String path; //目录结构,树形结构体现
    private Long depth; //第几层,1级2级目录
    private Long seq = 0L;//排序
    private OrgType orgType; //组织类型,集团
    private ActiveType active; //是否启动
    private Set<KnEmployeeOrganization> emps; //组织下的员工

    public KnOrganization() {
    }

    public KnOrganization(Long id) {
        setId(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSupId() {
        return supId;
    }

    public void setSupId(Long supId) {
        this.supId = supId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public OrgType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrgType orgType) {
        this.orgType = orgType;
    }

    public ActiveType getActive() {
        return active;
    }

    public void setActive(ActiveType active) {
        this.active = active;
    }

    public Set<KnEmployeeOrganization> getEmps() {
        return emps;
    }

    public void setEmps(Set<KnEmployeeOrganization> emps) {
        this.emps = emps;
    }

    public enum OrgType {//集团 公司 机构 部门 销售大区 销售区域 特许规划区域 客户支持区域
        GROUP, COMPANY, ORGANIZATION, DEPARTMENT, SALESREGION, SALESAREA, PLANINGCHART, CUSTOMERCHART
    }
}
