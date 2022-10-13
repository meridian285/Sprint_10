import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import ru.yandex.practikum.dataTests.LoginID;
import ru.yandex.practikum.steps.CourierSteps;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;
import static ru.yandex.practikum.config.Config.getBaseUri;
import static ru.yandex.practikum.generator.CourierDataGenerator.*;

public class CreateCourierTests {

    private CourierSteps courierSteps;
    @Before
    public void setUp(){
        courierSteps = new CourierSteps();
    }


    @Test
    @DisplayName("Авторизация курьера в системе с валидными значениями")
    public void checkCreateLoginCourierValidCredentials(){
        courierSteps.create(getRandomCourierRequestCreate())
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));

        Integer id = courierSteps.login(getRandomCourierRequestLogin())
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .extract()
                .path("id");

        courierSteps.delete(id)
                .assertThat()
                .statusCode(SC_OK)
                .body("ok", equalTo(true));
    }



    @Test
    public void checkCreateLoginCourierValidCredentials3() {
        courierSteps.login(getRandomCourierRequestLogin())
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .extract()
                .path("id");
    }
}
