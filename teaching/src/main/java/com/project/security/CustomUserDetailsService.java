package com.project.security;

import com.project.model.User;
import com.project.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;
 
    @Override
    @Transactional
    public UserDetails loadUserByLogin(String nameOrEmail)
            throws EmailNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByLoginOrEmail(nameOrEmail, surnameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with name or email : " + surnamenameOrEmail)
        );

        return CustomUserDetails.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "email", email)
        );

        return CustomUserDetails.create(user);
    }
}