package com.restful.api.auth.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
* @author Damiano Alves on 22/02/19
* damiano.alves@gmail.com
*/
public class UserCredentials {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    public UserCredentials() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
