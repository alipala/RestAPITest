package com.restapi.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi {
    public Response getAllBooking() {
        return given()
                .get("https://automationintesting.online/room/");
    }

    public Response getSpecificBooking(int bookingId) {
        return given()
                .get("https://automationintesting.online/room/" + bookingId);
    }
}
