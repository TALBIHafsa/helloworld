package com.example.helloworld.service;

import com.example.helloworld.model.dto.UserDto;
import com.example.helloworld.model.entity.User;
//import com.example.helloworld.model.mapper.UserMapper;
import com.example.helloworld.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
//
//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserRepo userRepo;

    public UserDto getUser(long id){
        Optional<User> user = this.userRepo.findById(id);
        if(user.isPresent()) {
            return UserDto.toDto(user.get());
        } return null;

    }

    public String addUser(UserDto user) {
        if(userRepo.existsById(user.getId())){
           return "already";
        }
        userRepo.save(User.toEntity(user));

        return "added";
    }

    public String deleteUser(long id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "user deleted successfully !!";
        }
        return "user does not exist in the database";
    }


    public UserDto putUser(UserDto user) {
        return  UserDto.toDto(userRepo.save(User.toEntity(user)));
    }

    public UserDto patchUsers(UserDto user) {

        Optional<User> updatedUser = userRepo.findById(user.getId());
        if(user.getName() == null) {

        }else{
            updatedUser.get().setName(user.getName());

        }
        if(user.getAge() == 0) {

        }else{
            updatedUser.get().setAge(user.getAge());

        }
        userRepo.save(updatedUser.get());
        return UserDto.toDto(updatedUser.get());


    }
}
