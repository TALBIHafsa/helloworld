package com.example.helloworld.model.entity;

import com.example.helloworld.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id will be unique for each user
    private long id;

    @Column
    private String name;

    @Column
    private int age ;

    public static User toEntity(UserDto dto){
      return User.builder()
              .id(dto.getId())
              .name(dto.getName())
              .age(dto.getAge())
              .build();
    }



}
