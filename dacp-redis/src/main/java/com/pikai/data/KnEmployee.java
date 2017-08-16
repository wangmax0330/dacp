package com.pikai.data;

import org.joda.time.DateTime;

import java.util.Set;

/**
 * 员工表
 * userId和userSystem为不可编辑项,生成后不可编辑--cici
 * 增加updateTime时间进行员工的增量更新--2015-1-19-cici
 *
 * @author chirs@zhoujin.com (Chirs Chou)
 */
public class KnEmployee extends EmployeeAuditEntity implements java.io.Serializable {
    private static final long serialVersionUID = -9108444631356975586L;
    private Long id;
    private Long appId;
    private Long firstLogin;
    private Long count;
    private String loginName;
    private String userName;
    private String imageAddress;//用户图像
    private String phone;//手机
    private String telephone;//座机
    private String email;//员工邮箱
    private String address;//地址
    private ActiveType job = ActiveType.DISABLE;//离职状态
    private Gender sex = Gender.NONE;//性别
    private String signature;//个性签名
    private Set<KnEmployeeOrganization> org;
    private Set<KnEmployeePosition> pos;
    private Set<KnTeam> team;
    //以下供第三方系统导入使用
    private String userType;//用户类型（员工，供应商，采购商）
    private String userId;//用户ID
    private String userSystem;//用户来自系统
    private String markName = "";//用户的唯一标识,用于标识一个人拥有多个用户时候的信息
    private String weixinId = "";//微信的唯一标识,微信id,主要用于用户绑定微信账号
    private Long workingTime;//在职时间
    private Long turnoverTime;//离职时间

    public KnEmployee() {
    }

    public KnEmployee(Long id) {
        setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public ActiveType getJob() {
        return job;
    }

    public void setJob(ActiveType job) {
        this.job = job;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Set<KnEmployeeOrganization> getOrg() {
        return org;
    }

    public void setOrg(Set<KnEmployeeOrganization> org) {
        this.org = org;
    }

    public Set<KnEmployeePosition> getPos() {
        return pos;
    }

    public void setPos(Set<KnEmployeePosition> pos) {
        this.pos = pos;
    }

    public Set<KnTeam> getTeam() {
        return team;
    }

    public void setTeam(Set<KnTeam> team) {
        this.team = team;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserSystem() {
        return userSystem;
    }

    public void setUserSystem(String userSystem) {
        this.userSystem = userSystem;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public enum Gender {
        MAN("男"), WOMEN("女"), NONE("无");
        private final String s_type;

        private Gender(final String s_type) {
            this.s_type = s_type;
        }

        public String getTypeName() {
            return s_type;
        }
    }

    public enum UserType {
        employee, supplier
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Long firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Long workingTime) {
        this.workingTime = workingTime;
    }

    public Long getTurnoverTime() {
        return turnoverTime;
    }

    public void setTurnoverTime(Long turnoverTime) {
        this.turnoverTime = turnoverTime;
    }

    public String getWorkT() {
        if (this.workingTime == null) {
            return "";
        } else {
            return new DateTime(workingTime).toString("yyyy-MM-dd");
        }
    }

    public String getTunT() {
        if (this.turnoverTime == null) {
            return "";
        } else {
            return new DateTime(turnoverTime).toString("yyyy-MM-dd");
        }
    }
}
