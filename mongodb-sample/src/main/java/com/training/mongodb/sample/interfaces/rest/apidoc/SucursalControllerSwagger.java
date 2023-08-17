package com.training.mongodb.sample.interfaces.rest.apidoc;

import com.training.mongodb.sample.infrastructure.dto.SucursalDTO;
import com.training.mongodb.sample.infrastructure.repository.entity.SucursalEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/sucursales/", produces = "application/json;charset=UTF-8")
@Api(tags = SucursalControllerSwagger.TAG)
public interface SucursalControllerSwagger {
    String TAG = "Sucursal API";
    
    @PostMapping
    @ApiOperation("Creates new sucursal")
    @Operation(summary = "Creates a new sucursal", tags = TAG)
    ResponseEntity<Void> insert(@Valid @RequestBody SucursalDTO sucursalDTO);


    @GetMapping
    @ApiOperation("Gets all Sucursales")
    @Operation(summary = "Gets all Sucursales", tags = TAG)
    ResponseEntity<List<SucursalDTO>> findAll();
}
