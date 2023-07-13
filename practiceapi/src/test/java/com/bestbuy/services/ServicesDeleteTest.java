package com.bestbuy.services;

import com.bestbuy.testbase.TestBase1;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesDeleteTest extends TestBase1 {
    @Test
    public void delete(){
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1")
                .when()
                .delete("{id}")
                .then()
                .statusCode(204);
    }


}
