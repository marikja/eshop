package com.eshop.controller;

import com.eshop.controller.dto.request.CreatePhoneRequest;
import com.eshop.model.Phone;
import com.eshop.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.ResourceLoaderUtil.asString;

@WebMvcTest(PhoneController.class)
class PhoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneService service;

    @Value("classpath:testdata/createPhone.json")
    private Resource createPhoneInJsonRequest;

    @Value("classpath:testdata/createPhone.xml")
    private Resource createPhoneInXmlRequest;

    @Test
    void testCreatePhone_jsonFile() throws Exception {
        Phone phone = new Phone();
        phone.setBrand("apple");
        phone.setModel("s12");
        phone.setImage(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 8, 0, 0, 0, 8,
                1, 3, 0, 0, 0, -2, -63, 44, -56, 0, 0, 0, 6, 80, 76, 84, 69, -1, -1, -1, -65, -65, -65, -93, 67, 118,
                57, 0, 0, 0, 14, 73, 68, 65, 84, 8, -41, 99, -8, 0, -123, -4, 16, 8, 0, 46, 0, 3, -3, -93, 105, 110,
                -47, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126});
        phone.setPrice(12000);
        phone.setOperatingSystem("ios");
        when(service.create(any())).thenReturn(phone);

        mockMvc.perform(post("/phones").content(asString(createPhoneInJsonRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("apple"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operating_system").value("ios"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("s12"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(12000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image").value("iVBORw0KGgoAAAANSUhE" +
                        "UgAAAAgAAAAIAQMAAAD+wSzIAAAABlBMVEX///+/v7+jQ3Y5AAAADklEQVQI12P4AIX8EAgALgAD" +
                        "/aNpbtEAAAAASUVORK5CYII="));

        ArgumentCaptor<CreatePhoneRequest> argumentCaptor = ArgumentCaptor.forClass(CreatePhoneRequest.class);
        verify(service).create(argumentCaptor.capture());
        CreatePhoneRequest request = argumentCaptor.getValue();
        assertEquals("apple", request.brand());
        assertEquals("ios", request.operatingSystem());
        assertEquals("s12", request.model());
        assertEquals(12000, request.price());
        assertEquals("iVBORw0KGgoAAAANSUhEUgAAAAgAAAAIAQMAAAD+wSzIAAAABlBMVEX///+/v7+jQ3Y5AAAADklEQVQI12P4AI" +
                "X8EAgALgAD/aNpbtEAAAAASUVORK5CYII=", request.image());
    }

    @Test
    void testCreatePhone_xmlFile() throws Exception {
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("Mpas123");
        phone.setImage(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 10, 0, 0, 0,
                10, 8, 2, 0, 0, 0, 2, 80, 88, -22, 0, 0, 0, 25, 73, 68, 65, 84, 120, -100, 98, 121, 113, -52, -107, 1,
                55, 96, -62, 35, 55, -126, -91, 1, 1, 0, 0, -1, -1, 106, 17, 2, 10, -18, -77, -13, 11, 0, 0, 0, 0, 73,
                69, 78, 68, -82, 66, 96, -126});
        phone.setPrice(13450);
        phone.setOperatingSystem("android");
        when(service.create(any())).thenReturn(phone);

        mockMvc.perform(post("/phones").content(asString(createPhoneInXmlRequest))
                        .contentType(MediaType.APPLICATION_XML)
                )
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("Samsung"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operating_system").value("android"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Mpas123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(13450))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image")
                        .value("iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAGUlEQVR4nGJ5ccyVATdgwiM3gq" +
                                "UBAQAA//9qEQIK7rPzCwAAAABJRU5ErkJggg=="));

        ArgumentCaptor<CreatePhoneRequest> argumentCaptor = ArgumentCaptor.forClass(CreatePhoneRequest.class);
        verify(service).create(argumentCaptor.capture());
        CreatePhoneRequest request = argumentCaptor.getValue();
        assertEquals("Samsung", request.brand());
        assertEquals("android", request.operatingSystem());
        assertEquals("Mpas123", request.model());
        assertEquals(13450, request.price() );
        assertEquals("iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAAGUlEQVR4nGJ5ccyVATdgwiM3gqUBAQAA//9qE" +
                "QIK7rPzCwAAAABJRU5ErkJggg==", request.image());
    }

}
