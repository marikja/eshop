package com.eshop.repository;

import com.eshop.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
    boolean existsByBrandAndModel(String brand, String model);
}
