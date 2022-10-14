package ru.yandex.practikum.generator;

import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.LoginRequest;

public class CourierDataGenerator {
    //ввод данных для создания курьера
    public static CourierData getCourierRequestCreate(){
        CourierData courierData = new CourierData();
        courierData.setLogin("qwerqwrqwr1");
        courierData.setPassword("1234");
        courierData.setFirstName("adsgrsrtg");
        return courierData;
    }
    //ввод даных для проверки логина в системе
    public static LoginRequest getCourierRequestLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwr1");
        loginRequest.setPassword("1234");
        return loginRequest;
    }
    //ввод данных для проверки регистрации курьера с одинаковыми данными
    public static CourierData getCourierRequestCreateLoginAgain(){
        CourierData courierData = new CourierData();
        courierData.setLogin("ahgr5h");
        courierData.setPassword("3453");
        courierData.setFirstName("dshgsb");
        return courierData;
    }
    //ввод данных для проверки логина
    public static LoginRequest getCourierRequestLoginAgain() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("ahgr5h");
        loginRequest.setPassword("3453");
        return loginRequest;
    }
    //данные для проверки возможности регистрации без поля login
    public static CourierData getCreateLoginCourierWithoutLoginField() {
        CourierData courierData = new CourierData();
        courierData.setLogin("");
        courierData.setPassword("3453");
        courierData.setFirstName("dshgsb");
        return courierData;
    }
    //данные для проверки возможности регистрации без поля login
    public static CourierData getCreateLoginCourierWithoutPasswordField() {
        CourierData courierData = new CourierData();
        courierData.setLogin("ahgr5h");
        courierData.setPassword("");
        courierData.setFirstName("dshgsb");
        return courierData;
    }
    //данные для проверки возможности выполнить вход без поля login
    public static LoginRequest getCourierRequestLoginWithoutLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("");
        loginRequest.setPassword("1234");
        return loginRequest;
    }
    //данные для проверки возможности выполнить вход без поля password
    public static LoginRequest getCourierRequestLoginWithoutPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwr1");
        loginRequest.setPassword("");
        return loginRequest;
    }
    public static LoginRequest getCourierRequestLoginWithInvalidCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwrssrhtdtyhd");
        loginRequest.setPassword("20347856");
        return loginRequest;
    }
}
