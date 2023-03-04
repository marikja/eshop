package com.eshop.service;

import com.eshop.controller.dto.request.CreatePhoneRequest;
import com.eshop.exception.PhoneAlreadyExistException;
import com.eshop.model.Phone;
import com.eshop.repository.PhoneRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PhoneServiceTest {

    private final PhoneRepository repository = mock(PhoneRepository.class);

    private final PhoneService  phoneService = new PhoneService(repository);

    @Test
    void testCreatePhone_notExist_shouldCreatePhone() {
        when(repository.existsByBrandAndModel(any(), any())).thenReturn(false);

        CreatePhoneRequest createPhoneRequest = new CreatePhoneRequest("apple", "ios", "S12", 1200,
                "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAASUVORK5CYII=");
        phoneService.create(createPhoneRequest);

        verify(repository).existsByBrandAndModel("apple", "S12");
        ArgumentCaptor<Phone> argumentCaptor = ArgumentCaptor.forClass(Phone.class);
        verify(repository).save(argumentCaptor.capture());
        Phone phone = argumentCaptor.getValue();
        assertNotNull(phone.getId());
        assertEquals("apple", phone.getBrand());
        assertEquals("ios", phone.getOperatingSystem());
        assertEquals("S12", phone.getModel());
        assertEquals(1200, phone.getPrice());
        assertArrayEquals(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 1, 0, 0, 0,
                1, 8, 4, 0, 0, 0, -75, 28, 12, 2, 0, 0, 0, 11, 73, 68, 65, 84, 24, 87, 99, 96, 96, 0, 0, 0, 3, 0, 1,
                104, 38, 89, 13, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126}, phone.getImage());
    }

    @Test
    void testCreatePhone_exist_shouldThrowException() {
        when(repository.existsByBrandAndModel(any(), any())).thenReturn(true);

        CreatePhoneRequest createPhoneRequest = new CreatePhoneRequest("apple", "ios", "S12", 1200,
                "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAASUVORK5CYII=");

        Throwable throwable = assertThrows(
                PhoneAlreadyExistException.class,
                () ->  phoneService.create(createPhoneRequest)
        );

        assertEquals(throwable.getMessage(), "Phone with brand apple and model S12 already exist.");
        verify(repository).existsByBrandAndModel("apple", "S12");
    }
}
