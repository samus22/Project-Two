package com.project.authentication;

import java.util.Collection;
import java.util.Optional;

import com.project.repository.IUserRepository;
import com.project.security.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ProjectTwoAuthentication implements Authentication {

    private UserDetails UserDetails = null;
    private boolean isAuthenticate = false;

    @Autowired
    IUserRepository userRepository;

    public ProjectTwoAuthentication(UserDetails UserDetails) {
        this.UserDetails = UserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.UserDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return "null";
    }

    @Override
    public Object getDetails() {
        return this.UserDetails;
    }

    @Override
    public Object getPrincipal() {
        return this.UserDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticate;
    }

    @Override
    public void setAuthenticated(boolean bln) throws IllegalArgumentException {
        this.isAuthenticate = bln;
    }

    @Override
    public String getName() {
        return this.UserDetails.getUsername();
    }
    
    public static Optional<CustomUserDetails> getUtilisateurConnecte() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            return Optional.of((CustomUserDetails)authentication.getPrincipal());
        }
        return Optional.empty();
    }
    
}