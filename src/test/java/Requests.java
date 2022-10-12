import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Requests {
    private final static String URL = "https://qa-scooter.praktikum-services.ru";


    public void createCourier(CourierData courierData){
                given()
                        .body(courierData)
                        .post(EndPoints.courier);
    }


}
