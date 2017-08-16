package com.pikai.tool;

/**
 * 项目名称：dacp
 * 包名： com.pikai.tool
 * 类名称：
 * 类描述：
 * 创建人:   沃特
 * 创建时间：2016/12/2016/12/31 17:10
 */
public class Student {
    private String Id;
    private String Name;
    private String Sex;
    private String Age;

    Student(String Name, String Sex, String Age) {
        this.Id = null; //default
        this.Name = Name;
        this.Sex = Sex;
        this.Age = Age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getAge() {
        return Age;
    }

    public void setage(String Age) {
        this.Age = Age;
    }
}