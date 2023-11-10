package com.senai.apivolksway.controllers;


import com.senai.apivolksway.dtos.ChecklistDto;
import com.senai.apivolksway.models.ChecklistModel;
import com.senai.apivolksway.repositories.ChecklistRepository;
import jakarta.validation.Valid;
import com.senai.apivolksway.services.FileUploadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/checklist", produces = {"application/json"})
public class ChecklistController {
    @Autowired
    ChecklistRepository checklistRepository;

    @Autowired
    FileUploadService fileUploadService;

    //Get
    @GetMapping
    public ResponseEntity<List<ChecklistModel>> listarChecklist() {
        return ResponseEntity.status(HttpStatus.OK).body(checklistRepository.findAll());
    }

    //Get por ID
    @GetMapping("/{idChecklist}")
    public ResponseEntity<Object> buscarChecklist(@PathVariable(value = "idChecklist") UUID id) {
        Optional<ChecklistModel> usuarioChecklist = checklistRepository.findById(id);

        if (usuarioChecklist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioChecklist.get());
    }

    //Post
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> criarChecklist(@ModelAttribute @Valid ChecklistDto checklistDto) {
        if (checklistRepository.findByFreio(checklistDto.freio().toString()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Checklist já cadastrado!");
        }

        ChecklistModel novoChecklist = new ChecklistModel();
        BeanUtils.copyProperties(checklistDto, novoChecklist);

        String urlImagem;

        try {
            urlImagem = fileUploadService.fazerUpload(checklistDto.imagem());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        novoChecklist.setFoto_pneu(urlImagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(checklistRepository.save(novoChecklist));

    }

    //Put
    @PutMapping(value = "/idChecklist", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> editarChecklist(@PathVariable(value = "idChecklist") UUID id, @ModelAttribute @Valid ChecklistDto checklistDto) {
        Optional<ChecklistModel> checklistBuscada = checklistRepository.findById(id);

        if (checklistBuscada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checklist não encontrada");
        }
        ChecklistModel checklistBd = checklistBuscada.get();
        BeanUtils.copyProperties(checklistDto, checklistBd);

        String urlImagem;

        try {
            urlImagem = fileUploadService.fazerUpload(checklistDto.imagem());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        checklistBd.setFoto_pneu(urlImagem);

        return ResponseEntity.status(HttpStatus.OK).body(checklistRepository.save(checklistBd));
    }

    //Delete
    @DeleteMapping("/{idChecklist}")
    public ResponseEntity<Object> deletarChecklist(@PathVariable(value = "idChecklist") UUID id) {
        Optional<ChecklistModel> checklistBuscada = checklistRepository.findById(id);

        if (checklistBuscada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        checklistRepository.delete(checklistBuscada.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso!");
    }
}
