package com.training.mongodb.sample.infrastructure.utils;

import com.training.mongodb.sample.infrastructure.dto.SucursalDTO;
import com.training.mongodb.sample.infrastructure.repository.entity.SucursalEntity;

public  class RepositoryMapper {

    public static SucursalEntity sucursalEntity(SucursalDTO sucursalDTO) {
        return SucursalEntity.builder()
                .address(sucursalDTO.getAddress())
                .type(sucursalDTO.getType())
                .openingHour(sucursalDTO.getOpeningHour())
                .closeHour(sucursalDTO.getCloseHour())
                .services(sucursalDTO.getServices())
                .code(sucursalDTO.getCode())
                .build();
    }
    public static SucursalDTO sucursalDto(SucursalEntity sucursalEntity) {
        return SucursalDTO.builder()
                .code(sucursalEntity.getCode())
                .address(sucursalEntity.getAddress())
                .openingHour(sucursalEntity.getOpeningHour())
                .closeHour(sucursalEntity.getCloseHour())
                .services(sucursalEntity.getServices())
                .type(sucursalEntity.getType())
                .code(sucursalEntity.getCode())
                .build();
    }
}
