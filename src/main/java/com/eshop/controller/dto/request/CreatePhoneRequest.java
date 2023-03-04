package com.eshop.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record CreatePhoneRequest(

        @NotBlank
        String brand,

        @NotBlank
        @JsonProperty("operating_system")
        String operatingSystem,

        @NotBlank
        String model,

        @PositiveOrZero
        int price,

        @NotBlank
        String image
) {
}
