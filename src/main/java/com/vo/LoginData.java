package com.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LoginData implements Serializable{

    private static final long serialVersionUID = -8271290369149235669L;

    private String username;
    private String password;
    private String salt;
    private Long  accountId;
    @ApiModelProperty("账号类型： 1、root 2、合伙人  3、管理员,默认的账户类型是3")
    private Integer accountType;
    private Map<String,String> customParam = new HashMap<>();


    public Map<String, String> getCustomParam() {
        return customParam;
    }

    public Map<String,String> setCustomParam(HashMap<String, String> customParam) {
        this.customParam.putAll(customParam);
        return this.customParam;
    }

    public Map<String,String> put(String key, String value){
        this.customParam.put(key, value);
        return this.customParam;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", accountId=" + accountId +
                ", accountType=" + accountType +
                ", customParam=" + customParam +
                '}';
    }
}
