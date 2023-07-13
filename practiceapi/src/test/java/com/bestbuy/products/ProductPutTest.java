package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.testbase.TestBase3;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPutTest extends TestBase3 {
    @Test
    public void updateProductWithPut(){
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Samsung1");
        productsPojo.setType("note12");
        productsPojo.setPrice(1550);
        productsPojo.setShipping(0);

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "43900")
                .body(productsPojo)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);
    }
}
