package com.senai.apivolksway.controllers;


import com.senai.apivolksway.dtos.VeiculoDto;
import com.senai.apivolksway.models.VeiculoModel;
import com.senai.apivolksway.repositories.VeiculoRepository;
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
@RequestMapping(value = "/veiculos", produces = {"application/json"})
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    //Get
    @GetMapping
    public ResponseEntity<List<VeiculoModel>> listarVeiculos() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.findAll());
    }

    //Get por ID
    @GetMapping("/{idVeiculo}")
   public ResponseEntity<Object> buscarVeiculo(@PathVariable(value = "idVeiculo") UUID id){
        Optional<VeiculoModel> veiculoBuscado = veiculoRepository.findById(id);

        if (veiculoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(veiculoBuscado.get());
    }

    //Post

    @PostMapping
    public ResponseEntity<Object> criarVeiculo(@ModelAttribute @Valid VeiculoDto veiculoDto){
        if (veiculoRepository.findByPlaca(veiculoDto.placa())!= null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veiculo já cadastrado!");
        }


    VeiculoModel novoVeiculo = new VeiculoModel();
    BeanUtils.copyProperties(veiculoDto, novoVeiculo);
    return ResponseEntity.status(HttpStatus.CREATED).body(veiculoRepository.save(novoVeiculo));
    }

    //Put

    @PutMapping(value = "/{idVeiculo}")
    public ResponseEntity<Object> editarVeiculo(@PathVariable(value = "idVeiculo") UUID id, @ModelAttribute @Valid VeiculoDto veiculoDto){
        Optional<VeiculoModel> veiculoBuscado = veiculoRepository.findById(id);

        if (veiculoBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
        }

        VeiculoModel veiculoBd = veiculoBuscado.get();
        BeanUtils.copyProperties(veiculoDto, veiculoBd);

        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculoBd));
    }

    //Delete
    @DeleteMapping("/{idVeiculo}")
    public ResponseEntity<Object> deletarVeiculo(@PathVariable(value = "idVeiculo") UUID id){
        Optional<VeiculoModel> veiculoBuscado = veiculoRepository.findById(id);

        if (veiculoBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
        }

        veiculoRepository.delete(veiculoBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Veiculo deletado com sucesso");
    }

}
