package com.senai.apivolksway.controllers;


import com.senai.apivolksway.dtos.UsuarioDto;
import com.senai.apivolksway.models.UsuarioModel;
import com.senai.apivolksway.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping (value = "/usuarios", produces = {"application/json"})
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Get
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());

    }

    //Get por ID
    @GetMapping("/{idUsuario}")

    public ResponseEntity<Object> buscarUsuario(@PathVariable(value = "idUsuario")UUID id){
        Optional<UsuarioModel> usuarioBuscado = usuarioRepository.findById(id);

        if (usuarioBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioBuscado.get());


    }

    //POST
    @PostMapping
    public ResponseEntity<Object> criarUsuario(@ModelAttribute @Valid UsuarioDto usuarioDto) {
        if (usuarioRepository.findByEmail(usuarioDto.email()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado!");
        }

        UsuarioModel novoUsuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, novoUsuario);


        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(novoUsuario));
    }

    //PUT
    @PutMapping(value = "/{idUsuario}")
    public ResponseEntity<Object> editarUsuario(@PathVariable(value = "idUsuario") UUID id, @ModelAttribute @Valid UsuarioDto usuarioDto) {
        Optional<UsuarioModel> usuarioBuscado = usuarioRepository.findById(id);

        if (usuarioBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado");
        }
        UsuarioModel usuarioBd = usuarioBuscado.get();
        BeanUtils.copyProperties(usuarioDto, usuarioBd);


        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioBd));

    }

    //DELETE
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "idUsuario") UUID id) {
        Optional<UsuarioModel> usuarioBuscado = usuarioRepository.findById(id);

        if (usuarioBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        usuarioRepository.delete(usuarioBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso!");
    }


}

