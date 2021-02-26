package com.valid.users.domain;

import org.springframework.context.ApplicationEvent;

import lombok.Data;


public class UserProccesEvent extends ApplicationEvent {

    
    private static final long serialVersionUID = 5686051287493493113L;
    private String name = "com.valid.event.userProcess";
    private String message;
    private String[] idUsers;

    public UserProccesEvent(Object source, String message,String[] idUsers) {
        super(source);
        this.message = message;
        this.idUsers = idUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String[] idUsers) {
        this.idUsers = idUsers;
    }

    


    
}
