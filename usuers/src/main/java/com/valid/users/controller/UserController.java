package com.valid.users.controller;

import java.util.List;

import com.valid.users.applicationservice.CreateUser;
import com.valid.users.applicationservice.UpdatedUserProcess;
import com.valid.users.applicationservice.UserList;
import com.valid.users.domain.UserDto;
import com.valid.users.domain.UsersIds;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UserController {

    private CreateUser createUser;
    private UserList userList;
    public UpdatedUserProcess updatedUserProcess;

    public UserController(CreateUser createUser, UserList userList, UpdatedUserProcess updatedUserProcess) {
        this.createUser = createUser;
        this.userList = userList;
        this.updatedUserProcess = updatedUserProcess;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> newUser(@RequestBody UserDto newUser) {
        return new ResponseEntity<>(createUser.createUser(newUser), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userList.getUserList(), HttpStatus.OK);
    }

    @PostMapping("/users/process")
    public ResponseEntity<String> newUserProces(@RequestBody UsersIds userIds) {
        updatedUserProcess.updateUserProcess(userIds.getIds());

        return new ResponseEntity<>("Process received", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }

}
