package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase2;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPostTest extends TestBase2 {
    @Test
    public void createStores(){
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

                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post()
                .then()
                .statusCode(201);


    }

}
