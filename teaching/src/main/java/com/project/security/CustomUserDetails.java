package com.project.security;

import com.project.model.User;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CustomUserDetails implements UserDetails {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private String telephone;
    private String monToken;
    private Boolean blocked;
    

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String email, String name, String surname, String password, String role, String monToken,
            Boolean blocked, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
        this.monToken = monToken;
        this.blocked = blocked;
        this.authorities = authorities;
    }

    public static CustomUserDetails create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        
        return new CustomUserDetails(
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getPassword(),
                user.getRole(),
                user.getMonToken(),
                user.getBlocked(),
                authorities
        );
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUserDetails that = (CustomUserDetails) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" + "email=" + email + ", name=" + name + ", surname=" + surname + ", role=" + role + ", monToken=" + monToken + ",  blocked" +blocked + ", authorities=" + authorities + '}';
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
