package com.project.service;

import java.util.List;


import com.project.model.*;

public interface UserService {

    public List<User> getAlUser();
    
    public User getUserByEmail(String email);

    public User addUser(User user);

    public void updateUser(User user);

    public void deleteUser(String email);
    
}