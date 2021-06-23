package com.project.ripunjoy.entities;

import javax.persistence.*;

@Entity
@Table(name="userZ")
public class UserEntity
{

    @Id @GeneratedValue
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    @Column(name="user_type")
    private boolean userType;
    @Column(name="email")
    private String email;
    @Column(name="confirmed")
    private boolean confirmed;
    @Column(name="mobile")
    private Long mobile;

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public UserEntity()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private UserEntity(String username, String password, boolean userType, String email, boolean confirmed) {
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
