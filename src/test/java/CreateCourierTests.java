import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.EndPoints;
import ru.yandex.practikum.dataTests.LoginID;
import ru.yandex.practikum.dataTests.LoginRequest;
import ru.yandex.practikum.steps.CourierSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static ru.yandex.practikum.config.Config.getBaseUri;

public class CreateCourierTests {

    private CourierSteps courierSteps;
    @Before
    public void setUp(){
        courierSteps = new CourierSteps();
    }

    @Test
    public void checkCreateLoginCourierValidCredentials(){
        CourierData courierData = new CourierData();
        Response response = courierSteps.create(courierData);
        response.then().extract().statusCode();
        response.then().extract().path("ok");

    }


    @Test
    public void checkCreateLoginCourierValidCredentials3(){

        CourierData courierData = new CourierData();
        Response response = courierSteps.create(courierData);
        response.then().extract().statusCode();
        response.then().extract().path("ok");


//        //выполняем логин для получения ID
//        LoginRequest loginRequest = new LoginRequest();
//        Response responseLogin = courierSteps.login(loginRequest);
//        responseLogin.then().extract().statusCode();
//        responseLogin.then().extract().path("ok");
//
//        //удаляем логин по ID
//        LoginID loginID = new LoginID();
//        Response responseDelete = courierSteps.delete(loginID);
//        responseDelete.then().extract().path("ok");
    }

//    @Test
//    public void checkCreateLoginCourierValidCredentials1(){
//        CourierData courierClass = new CourierData("qwerqwrqwr2", "1234","adsgrsrtg");
//                given()
//                        .header("Content-type", "application/json")
//                        .body(courierClass)
//                        .when()
//                        .post("/api/v1/courier");
//        Response response =
//                given()
//                        .header("Content-type", "application/json")
//                        .body(courierClass)
//                        .when()
//                        .post("/api/v1/courier");
//        response.then().assertThat()
//                .and()
//                .statusCode(409)
//                .body("message", equalTo("Этот логин уже используется"));
//
//    }
}
