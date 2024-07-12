package com.example.helloworld.controller;

import com.example.helloworld.model.dto.UserDto;
import com.example.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String helloWorld(){
        return "Hello World !!";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye";
    }



    // REST Methodes
    @GetMapping("/users")
    public UserDto getUser(@RequestParam long id){
        return userService.getUser(id);
    }


    @PostMapping("/addusers")
    public String saveUser(@RequestBody UserDto user) {
       return userService.addUser(user);
    }

    @DeleteMapping("/deleteusers")
    public String deleteUsers(long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/putusers")
    public UserDto putUsers(@RequestBody UserDto user){
        return  userService.putUser(user);

    }

    @PatchMapping("/patchusers")
    public UserDto patchUsers(@RequestBody UserDto user){
        return userService.patchUsers(user);
    }

//    @PostMapping("/users")
//    public String saveUser(@RequestBody User user){
//        userRepo.save(user);
//        return "saved";
//    }
//
//
//    @DeleteMapping("/users")
//    public String deleteUser(long id){
//        userRepo.deleteById(id);
//        return "deleted";
//    }
//
//
//    @PatchMapping("/update/{id}")
//    public String modifyUser(@PathVariable long id, @RequestBody User user){
//        User updatedUser = userRepo.findById(id).get();
//        updatedUser.setAge(user.getAge());
//        updatedUser.setName(user.getName());
//        userRepo.save(updatedUser);
//        return "user updated successfully";
//    }
}