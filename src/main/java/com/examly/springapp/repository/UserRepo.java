package com.examly.springapp.repository;

import com.examly.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByRole(String role);
    List<User> findByUsernameAndRole(String username, String role);
}
