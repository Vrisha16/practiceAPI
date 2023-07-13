package com.bestbuy.categories;

import com.bestbuy.model.CategariesPojo;
import com.bestbuy.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPatchTest extends TestBase {
    @Test
    public void patch(){
        CategariesPojo categariesPojo=new CategariesPojo();
        categariesPojo.setName("Machine");
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id","101")
                .body(categariesPojo)
                .when()
                .patch("/{id}")
                .then()
                .statusCode(200);

    }

}
