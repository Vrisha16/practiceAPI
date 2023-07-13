package com.bestbuy.stores;

import com.bestbuy.testbase.TestBase2;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreGetTest extends TestBase2 {
    static ValidatableResponse response;

    @Test
    public void getAllStudentsInfo() {
        response = given()
                .when()
                .get().then();
        response.statusCode(200);
    }

}
