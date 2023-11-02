package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;

public record VeiculoDto(

        @NotBlank
        String codigo_chassi,
        @NotBlank
        String marca,
        @NotBlank
        String placa
) {
}
