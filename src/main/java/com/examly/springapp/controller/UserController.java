package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user){
        User saved = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<User> get1(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User get2(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public User put(@PathVariable Long id, @RequestBody User user){
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteUser(id);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<?> get3(@PathVariable String role){
        List<User> users= service.getUsersByRole(role);
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No users found with role: " + role);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/username/{username}/role/{role}")
    public List<User> get4(@PathVariable String username, @PathVariable String role){
        return service.getUser(username,role);
    }
}
