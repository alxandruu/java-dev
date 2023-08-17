package com.training.mongodb.sample.application.services.sucursal;

import com.training.mongodb.sample.infrastructure.dto.SucursalDTO;
import com.training.mongodb.sample.infrastructure.repository.SucursalMongoRepository;
import com.training.mongodb.sample.infrastructure.repository.entity.SucursalEntity;
import com.training.mongodb.sample.infrastructure.repository.model.sucursal.SucursalAddress;
import com.training.mongodb.sample.infrastructure.utils.RepositoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements SucursalService {
    private final SucursalMongoRepository repo;

    @Override
    public SucursalEntity createSucursal(SucursalDTO sucursalDTO) {
        return this.repo.save(RepositoryMapper.sucursalEntity(sucursalDTO));
    }

    @Override
    public List<SucursalDTO> findAll() {
        return this.repo.findAll().stream().map(RepositoryMapper::sucursalDto).collect(Collectors.toList());
    }
}
