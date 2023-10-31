package com.senai.apivolksway.controllers;


import com.senai.apivolksway.models.EmpresaModel;
import com.senai.apivolksway.repositories.EmpresaRepository;
import com.senai.apivolksway.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping (value = "/empresas", produces = {"application/json"})
public class EmpresaController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    //Get
    @GetMapping
    public ResponseEntity<Object> buscarEmpresa(@PathVariable(value = "idEmpresa")UUID id){
        Optional<EmpresaModel> empresaBuscada = empresaRepository.findById(id);

        if (empresaBuscada.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
    }
}
