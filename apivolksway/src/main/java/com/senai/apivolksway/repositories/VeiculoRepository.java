package com.senai.apivolksway.repositories;

import com.senai.apivolksway.models.VeiculoModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, UUID> {
    VeiculoModel findByPlaca(String placa);
}
