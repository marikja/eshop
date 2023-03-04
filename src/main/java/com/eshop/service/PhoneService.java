package com.eshop.service;

import com.eshop.controller.dto.request.CreatePhoneRequest;
import com.eshop.exception.PhoneAlreadyExistException;
import com.eshop.model.Phone;
import com.eshop.repository.PhoneRepository;
import com.eshop.util.ImageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.List;

@Validated
@RequiredArgsConstructor
@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    /**
     * Create new phone if not exist. If phone with combination of same model and brand exists exception is thrown.
     *
     * @param request create phone request
     * @return created phone
     */
    @Transactional
    public Phone create(@Valid CreatePhoneRequest request) {
        if (phoneRepository.existsByBrandAndModel(request.brand(), request.model())) {
            throw new PhoneAlreadyExistException("Phone with brand " + request.brand() + " and model " +
                    request.model() + " already exist.");
        }

        Phone phone = new Phone();
        phone.setBrand(request.brand());
        phone.setModel(request.model());
        phone.setImage(ImageUtil.fromBase64(request.image()));
        phone.setPrice(request.price());
        phone.setOperatingSystem(request.operatingSystem());
        return phoneRepository.save(phone);
    }

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
}
