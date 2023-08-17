package com.training.mongodb.sample.application.services.sucursal;

import com.training.mongodb.sample.infrastructure.dto.SucursalDTO;
import com.training.mongodb.sample.infrastructure.repository.entity.SucursalEntity;

import java.util.List;


public interface SucursalService {

    SucursalEntity createSucursal(SucursalDTO sucursalDTO);
    List<SucursalDTO> findAll();

}
