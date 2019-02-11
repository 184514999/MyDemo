package com.drumbeatsoft.model;

import java.util.List;

//与数据库中users对应
public class UserInfo {
    private String id;         //用户id
    private String username;    //用户名
    private String password;       //密码
    private String companyId;   //所属公司id
    private String companyName;   //所属公司名称
    private int status;            //用户状态 1可用，2不可用
    private List<Role> roles;       //该用户所具有的角色
    private String name;            //用户昵称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                ", name='" + name + '\'' +
                '}';
    }
}
