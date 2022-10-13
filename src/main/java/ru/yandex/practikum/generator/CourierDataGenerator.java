package ru.yandex.practikum.generator;

import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.LoginID;
import ru.yandex.practikum.dataTests.LoginRequest;

public class CourierDataGenerator {
    public static CourierData getRandomCourierRequestCreate(){
        CourierData courierData = new CourierData();
        courierData.setLogin("qwerqwrqwr1");
        courierData.setPassword("1234");
        courierData.setFirstName("adsgrsrtg");
        return courierData;
    }

    public static LoginRequest getRandomCourierRequestLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwr1");
        loginRequest.setPassword("1234");
        return loginRequest;
    }

//    public static LoginID getIdLogin(){
//        LoginID loginID = new LoginID();
//        loginID.setId();
//    }
}
