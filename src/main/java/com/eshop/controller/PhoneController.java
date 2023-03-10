package com.eshop.controller;

import com.eshop.controller.dto.mapper.PhoneResponseMapper;
import com.eshop.controller.dto.request.CreatePhoneRequest;
import com.eshop.controller.dto.response.PhoneCreatedResponse;
import com.eshop.model.Phone;
import com.eshop.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/phones")
@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneCreatedResponse create(@RequestBody CreatePhoneRequest request) {
        Phone phone = phoneService.create(request);
        return PhoneResponseMapper.map(phone);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhoneCreatedResponse> findAll() {
        List<Phone> phones = phoneService.findAll();
        return PhoneResponseMapper.map(phones);
    }
}
