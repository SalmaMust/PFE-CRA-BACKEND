package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.User;
import com.example.demo.pferessourceshumaines.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin("*")
@RequestMapping("/api")
public class UserController {


        @Autowired
        private UserRepository userRepository;

        @GetMapping("/users")
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
            return ResponseEntity.ok().body(user);
        }

        @PostMapping("/user")
        public User createUser(@Valid @RequestBody User user) {
            return userRepository.save(user);
        }

        @PutMapping("/users/{id}")
        public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                               @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));

            user.setEmail(userDetails.getEmail());
            user.setLastname(userDetails.getLastname());
            user.setFirstname(userDetails.getFirstname());
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setPhone(userDetails.getPhone());
            user.setPoste(userDetails.getPoste());
            user.setRoles(userDetails.getRoles());
            user.setDate(userDetails.getDate());
            user.setGendar(userDetails.getGendar());
            user.setAddress(userDetails.getAddress());
            user.setBirthday(userDetails.getBirthday());
            user.setAbout(userDetails.getAbout());

            final User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        }

        @DeleteMapping("/users/{id}")
        public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));

            userRepository.delete(user);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
    }

