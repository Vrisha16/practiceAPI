package com.bestbuy.categories;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesGetTest extends TestBase {

    static ValidatableResponse response;

    @Test
    public void getAllCategoriesInfo() {
        response = given()
                .when()
                .get().then();
        response.statusCode(200);
    }
    @Test
    public void getSingleCategoriesInfo(){
        response= (ValidatableResponse) given()
                .pathParam("id",0020004)
                .when()
                .get("/{id}")
                .then();
        response.statusCode(404);

    }


}
