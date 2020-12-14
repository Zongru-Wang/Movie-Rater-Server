package com.example.wbdvsp20finalprojectserver.controllers;

import com.example.wbdvsp20finalprojectserver.models.User;
import com.example.wbdvsp20finalprojectserver.repositories.UserRepository;
import com.example.wbdvsp20finalprojectserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/api/users/{userId}")
    public User findUserById(@PathVariable("userId") int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/api/email/{email}")
    public User findUserByEmail(
            @PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("/api/users/{userId}")
    public int updateUser(@PathVariable("userId") int userId,
                            @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @GetMapping("/api/emails")
    public List<String> getEmails() {return userService.getEmails(); }

    @GetMapping("/api/credentials/{email}/{password}")
    public User findUserByCredentials(
            @PathVariable("email") String email,
            @PathVariable("password") String password) {
        return userService.findUserByCredentials(email, password);
    }

    @PostMapping("/api/create")
    public User createUser(
            @RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @PostMapping("/api/users/{userId}/likes/{movieId}")
    public int likeMovie(
            @PathVariable("userId") int userId,
            @PathVariable("movieId") String movieId) {
        return userService.likeMovie(userId, movieId);
    }

    @DeleteMapping("/api/users/{userId}/unlikes/{movieId}")
    public int unLikeMovie(
            @PathVariable("userId") int userId,
            @PathVariable("movieId") String movieId) {
        return userService.unLikeMovie(userId, movieId);
    }

    @DeleteMapping("/api/delete/{userId}")
    public int deleteUser(
            @PathVariable("userId") int id
    ) {
        return userService.deleteUser(id);
    }


    @PostMapping("/api/users/{userId}/follow/{followId}")
    public int follow(
            @PathVariable("userId") int userId,
            @PathVariable("followId") int followId) {
        return userService.follow(userId, followId);
    }

    @DeleteMapping("/api/users/{userId}/unFollow/{followId}")
    public int unFollow(
            @PathVariable("userId") int userId,
            @PathVariable("followId") int followId) {
        return userService.unFollow(userId, followId);
    }

}
