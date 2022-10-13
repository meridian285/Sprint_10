import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.dataTests.CourierData;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LoginCourierTests {
//    @Before
//    public void setUp() {
//        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
//    }
//
//    @Test
//    public void loginCourierWithValidCredentials(){
//        File json = new File("src/test/resources/ValidCredentials.json");
//        given()
//                .header("Content-type", "application/json")
//                .body(courierClass)
//                .when()
//                .post("/api/v1/courier");
//        Response response =
//                given()
//                        .header("Content-type", "application/json")
//                        .body(json)
//                        .when()
//                        .post("/api/v1/courier/login");
//        response.then().assertThat()
//                .and()
//                .statusCode(200)
//                .body(notNullValue());
//
//        System.out.println(response.body().asString());
//        System.out.println(response.statusCode());
//    }
}
