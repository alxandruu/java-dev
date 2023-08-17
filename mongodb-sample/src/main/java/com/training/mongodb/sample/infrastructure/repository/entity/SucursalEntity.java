package com.training.mongodb.sample.infrastructure.repository.entity;

import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalAdditionalInformation;
import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalAddress;
import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalServiceInformation;
import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = SucursalEntity.COLLECTION)
public class SucursalEntity {
    public static final String COLLECTION = "sucursales";

    @Id
    private String _id;
    private Integer code;
    private SucursalAddress address;
    private String openingHour;
    private String closeHour;
    private List<SucursalServiceInformation> services;
    private SucursalType type;
    private SucursalAdditionalInformation additionalInformation;

}
