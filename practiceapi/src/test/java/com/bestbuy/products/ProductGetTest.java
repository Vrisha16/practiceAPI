package com.bestbuy.products;

import com.bestbuy.testbase.TestBase3;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductGetTest extends TestBase3 {
    static ValidatableResponse response;

    @Test
    public void getAllStudentsInfo() {
        response = given()
                .when()
                .get().then();
        response.statusCode(200);
    }
    @Test
    public void getSingleProductInfo() {
        response =given()
                .pathParam("id",43900)
                .when()
                .get("/{id}")
                .then();
        response.statusCode(200);

    }
    @Test
    public void searchProductWithParameter() {
        response =given()
                .queryParam("type","HardGood")
                .queryParam("limit",10)
                .when()
                .get("/products")
                .then()
                .log().all();

        response.statusCode(500);
    }

}
