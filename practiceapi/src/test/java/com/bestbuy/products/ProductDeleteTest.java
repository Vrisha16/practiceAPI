package com.bestbuy.products;

import com.bestbuy.testbase.TestBase3;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductDeleteTest extends TestBase3 {
    @Test
    public void delete(){
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "43900")
                .when()
                .delete("{id}")
                .then()
                .statusCode(200);
    }


}
