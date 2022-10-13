package ru.yandex.practikum.generator;

import ru.yandex.practikum.dataTests.CourierData;

public class CourierDataGenerator {
    public static CourierData getRandomCourierRequest(){
        CourierData courierData = new CourierData();
        courierData.setLogin("qwerqwrqwr1");
        courierData.setPassword("1234");
        courierData.setFirstName("adsgrsrtg");
        return courierData;
    }
}
