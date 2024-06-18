package com.example.globalexceptionhandling.Controller;

import com.example.globalexceptionhandling.Entity.User;
import com.example.globalexceptionhandling.Exception.UserNotFoundException;
import com.example.globalexceptionhandling.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RestControllerAdvice
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findALl(){
        return userService.findAllUsersFromDB();
    }


    @GetMapping("/User/{id}")
    public User findUserById(@PathVariable int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }
    @PostMapping("/insert")
    public User insertUserIntoDb(@RequestBody User user){
        return userService.insertUserIntoDB(user);
    }


}
