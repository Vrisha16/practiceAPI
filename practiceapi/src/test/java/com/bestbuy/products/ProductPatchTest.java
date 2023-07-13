package com.bestbuy.products;

import com.bestbuy.model.ProductsPojo;
import com.bestbuy.testbase.TestBase3;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPatchTest extends TestBase3 {
    @Test
    public void updateProductWithPatch(){
        ProductsPojo productsPojo = new  ProductsPojo();
        productsPojo.setName("iphone");
        productsPojo.setPrice(599);


        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id","43900")
                .body(productsPojo)
                .when()
                .patch("/{id}")
                .then()
                .statusCode(200);


    }
}
