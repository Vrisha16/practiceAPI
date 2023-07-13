package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase2;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPutTest extends TestBase2 {
    @Test
            public void Put(){
    StoresPojo storesPojo = new StoresPojo();
     storesPojo.setName("Minnetonka");
        storesPojo.setType("SmallBox");
        storesPojo.setadress("135 london road");
        storesPojo.setCity("leicester");
        storesPojo.setState("midland");
        storesPojo.setZip("5225");
        storesPojo.setLat("12345");
        storesPojo.setIng("67890");
        storesPojo.setHours("7 to 10");

    given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "5")
                .body(storesPojo)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);

}

}