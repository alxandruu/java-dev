package com.training.mongodb.sample.infrastructure.repository.model.sucursal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SucursalAddress {
    private String city;
    private String zipCode;
    private String country;
    private String street;
    private double latitude;
    private double longitude;

}
