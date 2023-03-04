package com.eshop.controller.dto.mapper;

import com.eshop.controller.dto.response.PhoneCreatedResponse;
import com.eshop.model.Phone;
import com.eshop.util.ImageUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PhoneResponseMapper {

    public static PhoneCreatedResponse map(Phone phone) {
        PhoneCreatedResponse response = new PhoneCreatedResponse();
        response.setId(phone.getId());
        response.setBrand(phone.getBrand());
        response.setImage(ImageUtil.toBase64(phone.getImage()));
        response.setPrice(phone.getPrice());
        response.setModel(phone.getModel());
        response.setOperatingSystem(phone.getOperatingSystem());
        return response;
    }

    public static List<PhoneCreatedResponse> map(List<Phone> phones) {
        return phones.stream()
                .map(PhoneResponseMapper::map)
                .toList();
    }
}
