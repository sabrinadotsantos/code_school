package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioDto(

        String telefone,
        @NotBlank @Email(message = "O email deve estar no formato válido.") String email,

        @NotBlank String senha,

        @NotBlank
        LocalDate dataNascimento,

        @NotBlank
        String cidade,

        @NotBlank
        String cpf,

        @NotBlank
        Integer tipoUsuario,

        @NotBlank String nome,

        @NotNull UUID id_servico



        ) {
}
