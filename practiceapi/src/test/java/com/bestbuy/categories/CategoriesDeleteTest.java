package com.bestbuy.categories;

import com.bestbuy.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteTest extends TestBase {
    @Test
    public void delete(){
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "101")
                .when()
                .delete("{id}")
                .then()
                .statusCode(404);
    }
}
