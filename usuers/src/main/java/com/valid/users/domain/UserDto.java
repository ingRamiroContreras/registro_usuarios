package com.valid.users.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL) 
public class UserDto {

    @JsonProperty("user_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("process")
    private Boolean process;

    @JsonIgnore
    public User getUser() {
        if (this.id == null) {
            UUID uuid = UUID.randomUUID();
            this.id = uuid.toString();
        }
        return new User(this.id,this.name, this.lastName, Boolean.FALSE);
    }

    
    public static UserDto createUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getLastName(), user.getProcess());
    }

    
    public UserDto(String id,String name, String lastName, Boolean process) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.process = process;
    }

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getProcess() {
        return process;
    }

    public void setProcess(Boolean process) {
        this.process = process;
    }

    

    

}
