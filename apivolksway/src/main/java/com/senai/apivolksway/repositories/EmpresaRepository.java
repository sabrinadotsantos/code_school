package com.senai.apivolksway.repositories;

import com.senai.apivolksway.models.EmpresaModel;
import com.senai.apivolksway.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, UUID> {


}
