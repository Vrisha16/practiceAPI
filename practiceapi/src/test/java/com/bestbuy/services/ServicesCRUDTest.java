package com.bestbuy.services;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.model.ServicesPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesCRUDTest {
    static int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost"; // base URI
        RestAssured.port = 3030; // port number
        RestAssured.basePath = "/services"; // endpoints
    }

    @Test // get all list
    public void test001() {

        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test
    public void test002(){
        ServicesPojo datum = new ServicesPojo();
        datum.setName("Tesco Mobile");


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
        ProductsPojo datum = new ProductsPojo();


        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",idNumber)
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(404);

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
