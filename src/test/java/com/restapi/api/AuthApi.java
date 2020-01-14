package com.restapi.api;

import com.restapi.payloads.AuthLoginRequests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    public Response postLogin(AuthLoginRequests payload) {
        return given()
                .body(payload)
                .contentType(ContentType.JSON)
                .post("https://automationintesting.online/auth/login");
    }
}
