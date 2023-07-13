package com.bestbuy.services;

import com.bestbuy.testbase.TestBase1;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServiceGetTest extends TestBase1 {
    static ValidatableResponse response;

    @Test
    public void getAllStudentsInfo() {
        response = given()
                .when()
                .get().then();
        response.statusCode(200);
    }

}
