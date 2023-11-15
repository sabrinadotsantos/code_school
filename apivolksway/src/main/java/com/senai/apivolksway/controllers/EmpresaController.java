package com.senai.apivolksway.controllers;


import com.senai.apivolksway.dtos.EmpresaDto;
import com.senai.apivolksway.models.EmpresaModel;
import com.senai.apivolksway.repositories.EmpresaRepository;
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
@RequestMapping (value = "/empresas", produces = {"application/json"})
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;


    @GetMapping
    public ResponseEntity<List<EmpresaModel>> listarEmpresas(){
        return  ResponseEntity.status(HttpStatus.OK).body(empresaRepository.findAll());
    }

    //Get por ID
    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Object> buscarEmpresa(@PathVariable(value = "idEmpresa")UUID id){
        Optional<EmpresaModel> empresaBuscada = empresaRepository.findById(id);

        if (empresaBuscada.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(empresaBuscada.get());
    }

    //Post

    @PostMapping
    public ResponseEntity<Object> criarEmpresa(@RequestBody @Valid EmpresaDto empresaDto){
        if (empresaRepository.findByCnpj(empresaDto.cnpj()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado!");
        }

        EmpresaModel novaEmpresa = new EmpresaModel();
        BeanUtils.copyProperties(empresaDto, novaEmpresa);

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(novaEmpresa));
    }

    //Delete

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<Object> deletarEmpresa(@PathVariable(value = "idEmpresa") UUID id){
        Optional<EmpresaModel> empresaBuscada = empresaRepository.findById(id);

        if(empresaBuscada.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }

        empresaRepository.delete(empresaBuscada.get());
        return ResponseEntity.status(HttpStatus.OK).body("Empresa deletada com sucesso");
    }




}
