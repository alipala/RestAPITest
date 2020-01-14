package com.restapi.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthLoginResponse {
    @JsonProperty
    private String token;

    public AuthLoginResponse() {
    }

    public AuthLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
