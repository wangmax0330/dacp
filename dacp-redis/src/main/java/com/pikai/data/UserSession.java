package com.pikai.data;

import java.io.Serializable;
import java.util.*;

public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String USER_SESSION_KEY = "loginUser";

	public static final String NO_LOGIN_MSG = "no login";

	public static final String ERROR_LOGIN_MSG = "login validation error";

	public static final String REQUEST_LOGIN_MSG = "login validation connected timeout";

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", account=" + account + ", orgId="
				+ orgId + ", orgName=" + orgName + ", regionId=" + regionId
				+ ", deptId=" + deptId + ", deptName=" + deptName + ", name="
				+ name + "]";
	}



	/**
	 * 注意不要自动生成的时候不要直接覆盖了
	 * @param knRoles
     */
	public void setKnRoles(List<KnRole> knRoles) {
		if(knRoles!=null&&knRoles.size()>0){
			List<Long> knRoleIds=new ArrayList<>();
			List<String> knRoleCodeList=new ArrayList<>();
			for(KnRole role:knRoles) {
				knRoleIds.add(role.getId());
				knRoleCodeList.add(role.getCode());
			}
			this.setKnRoleIds(knRoleIds);
			this.setKnRoleCodeList(knRoleCodeList);
		}
		this.knRoles = knRoles;
	}

	private Long id; 	//用户id
	private Long ebsId;			//ebsId
	private Long ebsBizId;		//ebsBizId
	private String account;		//登陆账户名
	private Long orgId; 		// 分公司ID
	private String permissionsLevel;	//权限级别字段（BLOC,COMPANY,DEPT）
	private String orgName;		// 分公司名称
	private String orgCode;
	private Long regionId; 	// 区域Id
	private Long deptId; 	// 部门ID
	private String deptName; 	// 部门ID
	private String deptCode;
	private String deptDescription; //部门全称
	private String name;		//真实姓名
	private Date validDate;		//有效日期
	private Long roleId;
	private String sessionId;	//从session中取出sessionId，主要用作于数据权限的redisKey
	private String roleCode;
	private String xsimple; // cookie验证信息
    private List<Long> knRoleIds;//角色ID集合
	private List<String> knRoleCodeList;//角色编码集合
	/*private List<Long> knOrgIds;//分公司ID集合
	private List<Long> knDeptIds;//部门ID集合d*/

	//分公司权限集合
	private Set<Long> companyLevel;
	private Set<Long> deptLevel;    //部门级别
	private List<KnOrganization> orgs;//分公司集合
	private List<KnOrganization> depts;//部门集合

	private KnOrganization org;	//分公司信息
	private KnEmployee employee;	//员工信息
	private List<KnRole> knRoles;	//用户角色信息


	private Map<String,List<SysResourceVo>> roleResources;//用户角色资源信息



	//交付的权限过滤
	public List<Long> deptIds=new ArrayList<>();      //部门

	public List<KnOrganization> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<KnOrganization> orgs) {
		this.orgs = orgs;
	}

	public List<KnOrganization> getDepts() {
		return depts;
	}

	public void setDepts(List<KnOrganization> depts) {
		this.depts = depts;
	}

	public List<Long> getKnRoleIds() {
        return knRoleIds;
    }

    public void setKnRoleIds(List<Long> knRoleIds) {
        this.knRoleIds = knRoleIds;
    }

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public KnOrganization getOrg() {
		return org;
	}

	public void setOrg(KnOrganization org) {
		this.org = org;
	}

	public KnEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(KnEmployee employee) {
		this.employee = employee;
	}

	public List<KnRole> getKnRoles() {
		return knRoles;
	}

	public Map<String, List<SysResourceVo>> getRoleResources() {
		return roleResources;
	}

	public void setRoleResources(Map<String, List<SysResourceVo>> roleResources) {
		this.roleResources = roleResources;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getXsimple() {
		return xsimple;
	}
	public void setXsimple(String xsimple) {
		this.xsimple = xsimple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<String> getKnRoleCodeList() {
		return knRoleCodeList;
	}

	public void setKnRoleCodeList(List<String> knRoleCodeList) {
		this.knRoleCodeList = knRoleCodeList;
	}

	public Set<Long> getCompanyLevel() {
		return companyLevel;
	}

	public void setCompanyLevel(Set<Long> companyLevel) {
		this.companyLevel = companyLevel;
	}

	public String getDeptDescription() {
		return deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

	public Long getEbsId() {
		return ebsId;
	}

	public void setEbsId(Long ebsId) {
		this.ebsId = ebsId;
	}

	public Long getEbsBizId() {
		return ebsBizId;
	}

	public void setEbsBizId(Long ebsBizId) {
		this.ebsBizId = ebsBizId;
	}

	public List<Long> getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(List<Long> deptIds) {
		this.deptIds = deptIds;
	}

	public String getPermissionsLevel() {
		return permissionsLevel;
	}

	public void setPermissionsLevel(String permissionsLevel) {
		this.permissionsLevel = permissionsLevel;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Set<Long> getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(Set<Long> deptLevel) {
		this.deptLevel = deptLevel;
	}
}
