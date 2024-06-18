package com.example.globalexceptionhandling.Service;

import com.example.globalexceptionhandling.Entity.User;
import com.example.globalexceptionhandling.Exception.UserNotFoundException;
import com.example.globalexceptionhandling.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUserById(int id) throws UserNotFoundException {

        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User with Id" +id+ " is not present in the database"));

    }

    public List<User> findAllUsersFromDB(){
        return userRepo.findAll();
    }
    public User insertUserIntoDB(User user){

        return userRepo.save(user);
    }


}
