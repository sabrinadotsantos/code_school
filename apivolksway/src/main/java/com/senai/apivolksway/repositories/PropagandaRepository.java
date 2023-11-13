package com.senai.apivolksway.repositories;

import com.senai.apivolksway.models.PropagandaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropagandaRepository extends JpaRepository<PropagandaModel, UUID> {

    PropagandaModel findByTitulo(String titulo);
}
