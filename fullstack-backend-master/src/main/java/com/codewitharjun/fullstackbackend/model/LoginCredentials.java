package com.codewitharjun.fullstackbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "login_credentials")
public class LoginCredentials {

    @Id
    @GeneratedValue
    private Long login_id;
    @Column(unique = true)
    private String login_email;
    @Column(unique = true)

    private String login_password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public String getLogin_email() {
        return login_email;
    }

    public void setLogin_email(String login_email) {
        this.login_email = login_email;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}