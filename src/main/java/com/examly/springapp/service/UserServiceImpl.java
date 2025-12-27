package com.examly.springapp.service;

import java.util.*;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repo;

    public UserServiceImpl(UserRepo repo){
        this.repo=repo;
    }

    @Override
    public User createUser(User user){
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return repo.findAll();
    }

    @Override
    public User getUserById(Long id ){
        return repo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id , User user){
        User exist = getUserById(id);
        exist.setUsername(user.getUsername());
        exist.setEmail(user.getEmail());
        exist.setRole(user.getRole());  
        
        return repo.save(exist);
    }

    @Override
    public void deleteUser(Long id ){
        repo.deleteById(id);
    }

    @Override
    public List<User> getUsersByRole(String role){
        return repo.findByRole(role);
    }

    @Override
    public List<User> getUser(String username, String role){
        return repo.findByUsernameAndRole(username,role);
    }
    
}
