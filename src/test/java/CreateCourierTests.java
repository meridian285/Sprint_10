import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateCourierTests {
    private static final String basePath = "/api/v1/";
    ValidatableResponse
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
        RestAssured.basePath = basePath;
    }
    @Test
    public void test(){
        CourierClass courierClass = new CourierClass("qwerqwrqwr1", "1234","adsgrsrtg");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .post("/api/v1/courier");
        response.then().assertThat()
                .and()
                .statusCode(201)
                .body("ok", equalTo(true));
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }

    @Test
    public void createLoginCourierValidCredentials(){

        CourierClass courierClass = new CourierClass("qwerqwrqwr1", "1234","adsgrsrtg");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .post("/api/v1/courier");
        response.then().assertThat()
                .and()
                .statusCode(201)
                .body("ok", equalTo(true));
        //выполняем логин для получения ID
        LoginID loginID = given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .post(EndPoints.login)
                        .body()
                        .as(LoginID.class);
        //удаляем логин по ID
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .delete(EndPoints.courier+loginID.getId());

        System.out.println(EndPoints.courier+loginID.getId());
    }

    @Test
    public void createLoginCourierValidCredentials1(){
        CourierClass courierClass = new CourierClass("qwerqwrqwr2", "1234","adsgrsrtg");
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .post("/api/v1/courier");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .post("/api/v1/courier");
        response.then().assertThat()
                .and()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется"));



//        System.out.println(response.body().asString());
//        System.out.println(response.statusCode());
    }
}
