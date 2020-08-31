package com.example.demo.pferessourceshumaines.models.repository;


import com.example.demo.pferessourceshumaines.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository <User , Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername (String username);
    Boolean existsByEmail(String email);
    List<User> getAllByRole(String role);
    List<User> findAllByManagerId(Long id);
}
