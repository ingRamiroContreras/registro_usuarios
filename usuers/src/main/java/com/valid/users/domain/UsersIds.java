package com.valid.users.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UsersIds {

    @JsonProperty("user_ids")
    String[] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    
    
}
