package com.training.mongodb.sample.interfaces.rest;

import com.training.mongodb.sample.application.services.sucursal.SucursalService;
import com.training.mongodb.sample.infrastructure.dto.SucursalDTO;
import com.training.mongodb.sample.interfaces.rest.apidoc.SucursalControllerSwagger;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class SucursalController  implements SucursalControllerSwagger {

    private final SucursalService sucursalService;

    @Override
    public ResponseEntity<Void> insert(@Valid SucursalDTO sucursalDTO) {
        return (Objects.nonNull(this.sucursalService.createSucursal(sucursalDTO))) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<SucursalDTO>> findAll() {
        return ResponseEntity.ok(this.sucursalService.findAll());
    }
}
