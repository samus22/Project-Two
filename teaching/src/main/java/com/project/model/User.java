package com.project.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    private String email;

    private String name;
    private String surname;
    private String password;
    private String role;
    private String monToken = "";
    private Boolean blocked = false;

public User() {

}

public User(String email, String name, String surname, String password, String role) {
    this.email = email;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.role = role;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getSurname() {
    return surname;
}

public void setSurname(String surname) {
    this.surname = surname;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}

public String getMonToken() {
    return monToken;
}

public void setMonToken(String monToken) {
    this.monToken = monToken;
}

public Boolean getBlocked() {
    return blocked;
}

public void setBlocked(Boolean blocked) {
    this.blocked = blocked;
}

@Override
    public String toString() {
        return "User{" 
        + "email=" + email + ", name=" + name + ", surname=" + surname + ", password=" + password +  ", role=" + role + ", monToken=" + monToken + ",blocked" + blocked + '}';
    }
}