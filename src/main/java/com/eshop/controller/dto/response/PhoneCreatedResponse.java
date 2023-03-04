package com.eshop.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class PhoneCreatedResponse {
    private UUID id;
    private String brand;

    @JsonProperty("operating_system")
    private String operatingSystem;

    private String model;
    private int price;
    private String image;
}
