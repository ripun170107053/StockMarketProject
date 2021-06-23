package com.project.ripunjoy.models;

import javax.persistence.*;


public class UserModel
{

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;
    private boolean userType;

    private String email;
    private boolean confirmed;

    public UserModel()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private UserModel(String username, String password, boolean userType, String email, boolean confirmed) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.email = email;
        this.confirmed = confirmed;
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

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
