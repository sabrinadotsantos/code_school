package com.senai.apivolksway.dtos;

import com.senai.apivolksway.models.TipoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioDto(

        @NotNull UUID id_empresa,
        String telefone,
        @NotBlank @Email(message = "O email deve estar no formato válido.") String email,

        @NotBlank String senha,

        @NotBlank
        String data_nascimento,

        @NotBlank
        String cidade,

        @NotBlank
        String cpf,

        @NotBlank
        TipoModel tipo_usuario,

        @NotBlank String nome





        ) {
}
