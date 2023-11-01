package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;

public record VeiculoDto(

        @NotBlank
        String codigoChassi,
        @NotBlank
        String marca,
        @NotBlank
        String placa
) {
}
