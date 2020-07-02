package com.martin.s.usersapi.service;

import com.martin.s.usersapi.entity.User;
import com.martin.s.usersapi.exceptions.UserNotFoundException;
import com.martin.s.usersapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UserService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUserById(Integer Id) {
        User userToReturn = usersRepository.findById(Id).get();

        if(userToReturn == null) {
            throw new UserNotFoundException("User not found!");
        }

        return userToReturn;
    }

    @Override
    public User updateUser(User userToUpdate) {
        User user = usersRepository.findById(userToUpdate.getId()).get();

        if(user == null) {
            throw new UserNotFoundException("The user doesn't exist");
        }

        return usersRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserById(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public User saveUser(User userToSave) {
        return usersRepository.save(userToSave);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) usersRepository.findAll();
    }

}
