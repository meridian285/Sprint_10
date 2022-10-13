package ru.yandex.practikum.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.EndPoints;
import ru.yandex.practikum.dataTests.LoginID;
import ru.yandex.practikum.dataTests.LoginRequest;
import static io.restassured.RestAssured.given;



public class CourierSteps extends RestClient {
    //create
    public ValidatableResponse create(CourierData courierData) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(courierData)
                .post(EndPoints.COURIER)
                .then();
    }

    //login
    public ValidatableResponse login(LoginRequest loginRequest) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(loginRequest)
                .post(EndPoints.LOGIN)
                .then();
    }
        //delete
        public ValidatableResponse delete(Integer id) {
            return given()
                    .spec(getDefaultRequestSpec())
                    .body(id)
                    .post(EndPoints.DELETE)
                    .then();
        }
    }
