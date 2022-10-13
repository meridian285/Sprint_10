package ru.yandex.practikum.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.EndPoints;
import ru.yandex.practikum.dataTests.LoginID;
import ru.yandex.practikum.dataTests.LoginRequest;
import static io.restassured.RestAssured.given;
import static ru.yandex.practikum.config.Config.getBaseUri;
import static ru.yandex.practikum.generator.CourierDataGenerator.getRandomCourierRequest;

public class CourierSteps extends RestClient {
    //create
    public Response create(CourierData courierData) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(courierData)
                .post(EndPoints.COURIER);
    }

    //login
    public Response login(LoginRequest loginRequest) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(loginRequest)
                .post(EndPoints.COURIER);
    }
        //delete
        public Response delete(LoginID loginID) {
            return given()
                    .spec(getDefaultRequestSpec())
                    .body(loginID)
                    .post(EndPoints.DELETE);
        }
    }
