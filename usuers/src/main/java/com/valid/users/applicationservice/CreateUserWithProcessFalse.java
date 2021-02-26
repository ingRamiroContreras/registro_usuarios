package com.valid.users.applicationservice;

import com.valid.users.domain.User;
import com.valid.users.domain.UserDto;
import com.valid.users.infraestructure.UsersRepository;

import org.springframework.stereotype.Service;

@Service
public class CreateUserWithProcessFalse implements CreateUser {

    private UsersRepository repository;
    
    public CreateUserWithProcessFalse(UsersRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDto createUser(UserDto user) {
        User userToSave = user.getUser();
        User saveUser = repository.saveAndFlush(userToSave);
        
        return UserDto.createUserDto(saveUser);
    }

    
}
