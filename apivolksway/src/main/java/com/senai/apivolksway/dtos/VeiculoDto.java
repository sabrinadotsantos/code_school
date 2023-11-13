package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record VeiculoDto(

        @NotNull UUID id_usuario,
        @NotBlank
        String codigo_chassi,
        @NotBlank
        String marca,
        @NotBlank
        String placa
) {
}
