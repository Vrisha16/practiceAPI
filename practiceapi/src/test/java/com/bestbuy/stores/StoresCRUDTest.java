package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresCRUDTest {
    static int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost"; // base URI
        RestAssured.port = 3030; // port number
        RestAssured.basePath = "/stores"; // endpoints
    }

    @Test // get all list
    public void test001() {

        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test // post new and retrive id
    public void test002() {

        StoresPojo datum = new StoresPojo();
        datum.setName("Minnetonka");
        datum.setType("BigBox");
        datum.setadress("13513 Ridgedale Dr");
        datum.setCity("Leicester");
        datum.setState("Midland");
        datum.setZip("55305");
        datum.setLat("44.969658");
        datum.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        datum.setCreatedAt("2016-11-17T17:57:05.708Z");
        datum.setUpdatedAt("2016-11-17T17:57:05.708Z");


        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(datum)
                .post();
         response.then().statusCode(400);
        idNumber=response.then().extract().path("id");
        System.out.println(idNumber);
    }
    @Test //update id
    public void test003() {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Computer");
        storesPojo.setType("inspirion");
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", idNumber)
                .when()
                .body(storesPojo)
                .patch("/{id}");
        response.then().statusCode(200);
    }

        @Test// delete it
    public void test004() {
            Response response =given()
                    .log().all()
                    .header("Content-Type","application/json")
                    .pathParam("id",idNumber)
                    .when()
                    .delete("/{id}");
            response.then().statusCode(200);

        }

    @Test// retrive id and validate
    public void test005() {
        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",idNumber)
                .when()
                .get("/{id}");
        response.then().statusCode(404);

    }
    @Test // get only 1 by query parameter
    public void test006() {

        given()
                .queryParam("$limit","1")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }

}
