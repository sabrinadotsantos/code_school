package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmpresaDto(
        @NotBlank String razaoSocial,

        String cidade,

        @NotBlank
        String cnpj



) {
}
