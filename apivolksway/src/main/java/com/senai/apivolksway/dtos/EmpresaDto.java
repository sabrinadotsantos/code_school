package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmpresaDto(
        @NotBlank String razao_social,

        String cidade,

        @NotBlank
        String cnpj



) {
}
