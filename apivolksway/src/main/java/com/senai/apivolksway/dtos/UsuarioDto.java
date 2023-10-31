package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record UsuarioDto(
        @NotBlank String nome,
        String telefone,
        @NotBlank @Email(message = "O email deve estar no formato válido.") String email,

        @NotBlank String senha,

        LocalDate dataNascimento,

        String cidade,

        String cpf,

        Integer tipoUsuario


) {
}
