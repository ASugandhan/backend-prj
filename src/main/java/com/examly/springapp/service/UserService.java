package com.examly.springapp.service;

import com.examly.springapp.model.User;
import java.util.*;

public interface UserService {
        User createUser(User user);
        List<User> getAllUsers();
        User getUserById(Long id);
        User updateUser(Long id , User user);
        void deleteUser(Long id);
        List<User> getUsersByRole(String role);
        List<User> getUser(String username, String role);
}
