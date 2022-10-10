import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateCourierTests {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    public void createLoginCourierValidCredentials(){
        LoginID loginID = new LoginID();
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
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .post("/api/v1/courier/login")
                        .body()
                        .as(LoginID.class);
        //удаляем логин по ID
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .delete("/api/v1/courier/"+loginID+"");

        System.out.println(response.body().asString());
        System.out.println(response.statusCode());
        System.out.println(loginID);
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

    @Test
    public void deleteLoginCourier(){
        CourierClass courierClass = new CourierClass("qwerqwrqwr2", "1234","adsgrsrtg");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .when()
                        .delete("/api/v1/courier/112640");
        response.then().assertThat()
                .and()
                .statusCode(200)
                .body("ok", equalTo(true));

        System.out.println(response.body().asString());
        System.out.println(response.statusCode());
    }
}
