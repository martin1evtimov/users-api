package com.martin.s.usersapi.service;

import com.martin.s.usersapi.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    User updateUser(User userToUpdate);

    void deleteUserById(Integer id);

    User saveUser(User userToSave);

    List<User> getAllUsers();
}
