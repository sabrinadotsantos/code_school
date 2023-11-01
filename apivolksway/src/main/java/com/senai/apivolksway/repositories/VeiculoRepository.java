package com.senai.apivolksway.repositories;

import com.senai.apivolksway.models.UsuarioModel;
import com.senai.apivolksway.models.VeiculoModel;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, UUID> {
    VeiculoModel findByCodChassi(String codigoChassi);
}
