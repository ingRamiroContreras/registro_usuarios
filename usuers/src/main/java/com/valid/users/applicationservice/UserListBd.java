package com.valid.users.applicationservice;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.valid.users.domain.User;
import com.valid.users.domain.UserDto;
import com.valid.users.infraestructure.UsersRepository;

import org.springframework.stereotype.Service;

@Service
public class UserListBd implements UserList {

    public UserListBd(UsersRepository repository) {
        this.repository = repository;
    }


    private UsersRepository repository;
    

    @Override
    public List<UserDto> getUserList() {

        List<User> usersBdList = repository.findAll();
        
        return usersBdList.stream().map(UserDto::createUserDto).collect(Collectors.toList());
    }

    
}
