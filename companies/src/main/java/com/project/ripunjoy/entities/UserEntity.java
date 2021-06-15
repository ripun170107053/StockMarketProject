package com.project.ripunjoy.entities;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserEntity
{

    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;
    @Column
    private boolean userType;
    @Column
    private String email;
    @Column
    private boolean confirmed;

    public UserEntity()
    {

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
