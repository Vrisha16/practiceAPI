package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.testbase.TestBase3;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase3 {
    @Test
    public void createProduct() {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Samsung");
        productsPojo.setType("note14");
        productsPojo.setPrice(1500);
        productsPojo.setShipping(0);
        productsPojo.setUpc("8200040203");
        productsPojo.setDescription("hello world");
        productsPojo.setManufacturer("Samsung");
        productsPojo.setModel("samsung10");
        productsPojo.setUrl("www.samsung.com");

        given()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .when()
                .post()
                .then()
                .statusCode(201);

    }

}

