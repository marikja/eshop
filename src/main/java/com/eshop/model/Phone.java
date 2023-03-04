package com.eshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Phone {

    @Id
    @Column(updatable = false, unique = true)
    private final UUID Id = UUID.randomUUID();

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String operatingSystem;

    @Column(nullable = false)
    private String model;

    private int price;

    @Lob
    private byte[] image;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant created;
}
