package com.senai.apivolksway.controllers;


import com.senai.apivolksway.models.EmpresaModel;
import com.senai.apivolksway.models.PropagandaModel;
import com.senai.apivolksway.repositories.PropagandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping (value = "/propagandas", produces = {"application/json"})
public class PropagandaController {

    @Autowired
    PropagandaRepository propagandaRepository;

    @GetMapping
    public ResponseEntity<List<PropagandaModel>> listarPropagandas() {
        return ResponseEntity.status(HttpStatus.OK).body(propagandaRepository.findAll());
    }

}
    //Get por ID
//    @GetMapping("/{idPropaganda}")
//
//    public ResponseEntity<Object> buscarPropaganda(@PathVariable(value = "idPropaganda") UUID id){
//        Optional<PropagandaModel> propagandaBuscada = propagandaRepository.findById(id);
//
//        if (propagandaBuscada.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Propaganda não encontrada");
//        }


