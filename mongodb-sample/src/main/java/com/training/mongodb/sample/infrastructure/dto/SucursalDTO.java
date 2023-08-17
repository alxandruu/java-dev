package com.training.mongodb.sample.infrastructure.dto;

import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalAddress;
import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalServiceInformation;
import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
@Builder
public class SucursalDTO {
    private Integer code;
    private SucursalAddress address;
    private String openingHour;
    private String closeHour;
    private List<SucursalServiceInformation> services;
    private SucursalType type;
}
