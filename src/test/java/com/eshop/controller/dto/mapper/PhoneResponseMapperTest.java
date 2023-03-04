package com.eshop.controller.dto.mapper;

import com.eshop.controller.dto.response.PhoneCreatedResponse;
import com.eshop.model.Phone;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PhoneResponseMapperTest {

    @Test
    void testMapPhone() {
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("Mpas123");
        phone.setImage(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 10, 0, 0, 0,
                10, 8, 2, 0, 0, 0, 2, 80, 88, -22, 0, 0, 0, 25, 73, 68, 65, 84, 120, -100, 98, 121, 113, -52, -107, 1,
                55, 96, -62, 35, 55, -126, -91, 1, 1, 0, 0, -1, -1, 106, 17, 2, 10, -18, -77, -13, 11, 0, 0, 0, 0, 73,
                69, 78, 68, -82, 66, 96, -126});
        phone.setPrice(13450);
        phone.setOperatingSystem("android");

        PhoneCreatedResponse response = PhoneResponseMapper.map(phone);

        assertNotNull(response.getId());
        assertEquals("Samsung", response.getBrand());
        assertEquals("android", response.getOperatingSystem());
        assertEquals("Mpas123", response.getModel());
        assertEquals(13450, response.getPrice());
        assertEquals("iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAGUlEQVR4nGJ5ccyVATdgwiM3gqUBAQAA//" +
                "9qEQIK7rPzCwAAAABJRU5ErkJggg==", response.getImage());

    }

    @Test
    void testMapPhoneList() {
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("Mpas123");
        phone.setImage(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 10, 0, 0, 0,
                10, 8, 2, 0, 0, 0, 2, 80, 88, -22, 0, 0, 0, 25, 73, 68, 65, 84, 120, -100, 98, 121, 113, -52, -107, 1,
                55, 96, -62, 35, 55, -126, -91, 1, 1, 0, 0, -1, -1, 106, 17, 2, 10, -18, -77, -13, 11, 0, 0, 0, 0, 73,
                69, 78, 68, -82, 66, 96, -126});
        phone.setPrice(13450);
        phone.setOperatingSystem("android");

        Phone phoneApple = new Phone();
        phoneApple.setBrand("Apple");
        phoneApple.setModel("s132");
        phoneApple.setImage(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0,
                0, 0, 1, 0, 0, 0, 1, 8, 4, 0, 0, 0, -75, 28, 12, 2, 0, 0, 0, 11, 73, 68, 65, 84, 24, 87, 99, 96, 96, 0,
                0, 0, 3, 0, 1, 104, 38, 89, 13, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126});
        phoneApple.setPrice(13820);
        phoneApple.setOperatingSystem("ios");

        List<Phone> phones = List.of(phone, phoneApple);

        List<PhoneCreatedResponse> responses = PhoneResponseMapper.map(phones);

        assertEquals(2, responses.size());
        PhoneCreatedResponse response = responses.get(0);
        assertNotNull(response.getId());
        assertEquals("Samsung", response.getBrand());
        assertEquals("android", response.getOperatingSystem());
        assertEquals("Mpas123", response.getModel());
        assertEquals(13450, response.getPrice());
        assertEquals("iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAGUlEQVR4nGJ5ccyVATdgwiM3gqUBAQAA//" +
                "9qEQIK7rPzCwAAAABJRU5ErkJggg==", response.getImage());
        PhoneCreatedResponse appleResponse = responses.get(1);
        assertNotNull(appleResponse.getId());
        assertEquals("Apple", appleResponse.getBrand());
        assertEquals("ios", appleResponse.getOperatingSystem());
        assertEquals("s132", appleResponse.getModel());
        assertEquals(13820, appleResponse.getPrice());
        assertEquals("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAA" +
                "SUVORK5CYII=", appleResponse.getImage());
    }
}
