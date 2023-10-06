package com.aswebshop.demo.security.data;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    @Column(unique = true)
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> authorities;
    public User() {

    }

    public User(String firstName, String email, String password, Set<String> authorities) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
