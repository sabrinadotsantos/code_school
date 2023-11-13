package com.senai.apivolksway.controllers;

import com.senai.apivolksway.dtos.InteresseDto;
import com.senai.apivolksway.models.InteresseModel;
import com.senai.apivolksway.repositories.InteresseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping (value = "/interesses", produces = {"application/json"})
public class InteresseController {

    @Autowired
    InteresseRepository interesseRepository;

    @GetMapping
    public ResponseEntity<List<InteresseModel>> listarInteresses(){
        return ResponseEntity.status(HttpStatus.OK).body(interesseRepository.findAll());
    }

    //Get por ID

    @GetMapping("/{idInteresse}")
    public ResponseEntity<Object> buscarInteresse(@PathVariable(value = "idInteresse") UUID id){
        Optional<InteresseModel> interesseBuscado = interesseRepository.findById(id);

        if (interesseBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(interesseBuscado.get());
    }

    //Post

    @PostMapping
    public ResponseEntity<Object> criarInteresse(@ModelAttribute @Valid InteresseDto interesseDto){


        if (interesseRepository.findByEmail(interesseDto.email()).toString() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Interesse já cadastrado!");
        }

        InteresseModel novoInteresse = new InteresseModel();
        BeanUtils.copyProperties(interesseDto, novoInteresse);

        return ResponseEntity.status(HttpStatus.CREATED).body(interesseRepository.save(novoInteresse));
    }

    //Delete

    @DeleteMapping("/{idInteresse}")
    public ResponseEntity<Object> deletarInteresse(@PathVariable(value = "idInteresse") UUID id){
        Optional<InteresseModel> interesseBuscado = interesseRepository.findById(id);

        if(interesseBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse não encontrado");
        }

        interesseRepository.delete(interesseBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Interesse deletado com sucesso");
    }
}
