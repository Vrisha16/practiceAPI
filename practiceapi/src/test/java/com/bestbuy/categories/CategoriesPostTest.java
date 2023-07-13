package com.bestbuy.categories;

import com.bestbuy.model.CategariesPojo;
import com.bestbuy.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPostTest extends TestBase {
    @Test
    public void createcategories(){
        CategariesPojo categoriespojo = new CategariesPojo();
        categoriespojo.setName("Gift challange");
        categoriespojo.setUpdatedAt("2023-07-13T20:53:52.461Z");
        categoriespojo.setCreatedAt("2023-07-13T20:53:52.461Z");



        given()
                .header("Content-Type", "application/json")
                .body(categoriespojo)
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}
