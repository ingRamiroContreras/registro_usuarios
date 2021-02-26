package com.valid.users.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private  String id;

    private  String name;

    private  String lastName;

    private  Boolean process;

    public User(String id,String name, String lastName, Boolean process) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.process = process;
    }


    public User(){}

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
