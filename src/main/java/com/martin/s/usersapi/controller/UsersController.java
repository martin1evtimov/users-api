package com.martin.s.usersapi.controller;

import com.martin.s.usersapi.entity.User;
import com.martin.s.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/getAll", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> saveUser(@RequestBody User userToSave) {
        return new ResponseEntity<>(userService.saveUser(userToSave), HttpStatus.CREATED);
    }
}
