package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductCRUDTest {
    static int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost"; // base URI
        RestAssured.port = 3030; // port number
        RestAssured.basePath = "/products"; // endpoints
    }
    @Test //get all list
    public void test001(){
        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }
    @Test // post new and retrive id
    public void test002() {
        ProductsPojo datum = new ProductsPojo();
        datum.setName("Duracell - AAA Batteries (4-Pack)");
        datum.setType("HardGood");
        datum.setPrice(549);
        datum.setUpc("041333424019");
        datum.setShipping(0);
        datum.setDescription("Compatible with select electronic devices; AAA size; DURALOCK  Power Preserve technology; 4-pack");
        datum.setManufacturer("BMW");
        datum.setModel("series7");
        datum.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC");

        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(datum)
                .post();
        response.then().statusCode(201);
        idNumber = response.then().extract().path("id");
        System.out.println(idNumber);
    }
    @Test // update id
public void test003(){
        ProductsPojo datum =new ProductsPojo();
        Response response = given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(datum)
                .patch("id");
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


