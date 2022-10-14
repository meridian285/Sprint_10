import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.steps.CourierSteps;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static ru.yandex.practikum.generator.CourierDataGenerator.*;

public class LoginCourierTests {
    private CourierSteps courierSteps;
    //переменная для получения ID, используется для удаления данных
    private Integer id;

    @Before
    public void setUp() {
        courierSteps = new CourierSteps();
    }

    @After
    //удаляем данные после каждого теста
    public void tearDown(){
        if(id != null){
            courierSteps.delete(id).assertThat().statusCode(SC_OK).body("ok", equalTo(true));
        }
    }

    @Test
    public void checkLoginCourierWithoutLoginField() {
        //создается логин
        courierSteps.create(getCourierRequestCreate())
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
        //проверка создан ли логин, получаем id для удаления
        id = courierSteps.login(getCourierRequestLogin())
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .extract()
                .path("id");
        //проверка можно ли залогиниться используя только login
        courierSteps.login(getCourierRequestLoginWithoutLogin())
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для входа"));
    }
    @Test
    public void checkLoginCourierWithoutPasswordField() {
        //создается логин
        courierSteps.create(getCourierRequestCreate())
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
        //проверка создан ли логин, получаем id для удаления
        id = courierSteps.login(getCourierRequestLogin())
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .extract()
                .path("id");
        //проверка можно ли залогиниться используя только login
        courierSteps.login(getCourierRequestLoginWithoutPassword())
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для входа"));
    }
    @Test
    public void checkLoginCourierWithInvalidCredentials() {
        //проверка на логин с несуществующими данными
        courierSteps.login(getCourierRequestLoginWithInvalidCredentials())
                .assertThat()
                .statusCode(SC_NOT_FOUND)
                .body("message", equalTo("Учетная запись не найдена"));
    }

}
