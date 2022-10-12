import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;

public class CreateCourierTests {
    private final static String URL = "https://qa-scooter.praktikum-services.ru";

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";

    }

    @Test
    public void checkCreateLoginCourierValidCredentials2(){
        Specifications.installSpec(Specifications.reqSpec(URL),Specifications.respSpec(201));
        CourierData courierData = new CourierData("qwerqwrqwr1", "1234","adsgrsrtg");
        Requests requests = new Requests();
        requests.createCourier(courierData);
    }

    @Test
    public void checkCreateLoginCourierValidCredentials(){

        CourierData courierClass = new CourierData("qwerqwrqwr1", "1234","adsgrsrtg");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .post(EndPoints.courier);
        response.then().assertThat()
                .statusCode(201)
                .body("ok", equalTo(true));
        //выполняем логин для получения ID
        LoginID loginID = given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .post(EndPoints.login)
                        .as(LoginID.class);
        //удаляем логин по ID
                given()
                        .header("Content-type", "application/json")
                        .body(courierClass)
                        .delete(EndPoints.delete+loginID.getId());

        System.out.println();
        System.out.println(EndPoints.delete+loginID.getId());
    }

    @Test
    public void checkCreateLoginCourierValidCredentials1(){
        CourierData courierClass = new CourierData("qwerqwrqwr2", "1234","adsgrsrtg");
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

    }
}
