package com.bestbuy.categories;



import com.bestbuy.model.CategariesPojo;
import com.bestbuy.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPutTest extends TestBase {
    @Test
    public void updateCategoriesWithPut(){
        CategariesPojo categariesPojo=new CategariesPojo();
        categariesPojo.setName("Gift names");


        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "101")
                .body(categariesPojo)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);
    }

}

