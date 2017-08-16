package com.pikai.data;

import java.util.Set;

/**
 * 团队表
 *
 * @author chirs@zhoujin.com (Chirs Chou)
 */
public class KnTeam extends ExtraEntity {
    private static final long serialVersionUID = -6318347940649306088L;
    private String code;//编码
    private String name; //名称
    private String description; //描述
    private KnEmployee master;//负责人
    private Set<KnEmployee> emps;//团队下的人员列表
    private Setting.ActiveType active;

    public KnTeam(String code, String name, String description, KnEmployee master, Setting.ActiveType active) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.master = master;
        this.active = active;
    }

    public KnTeam() {
    }

    public KnTeam(Long id) {
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

    public KnEmployee getMaster() {
        return master;
    }

    public void setMaster(KnEmployee master) {
        this.master = master;
    }

    public Set<KnEmployee> getEmps() {
        return emps;
    }

    public void setEmps(Set<KnEmployee> emps) {
        this.emps = emps;
    }

    public Setting.ActiveType getActive() {
        return active;
    }

    public void setActive(Setting.ActiveType active) {
        this.active = active;
    }

}