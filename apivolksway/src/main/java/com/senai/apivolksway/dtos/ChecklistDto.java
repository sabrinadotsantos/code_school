package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record ChecklistDto(

        @NotNull UUID id_veiculo,
        @NotBlank Boolean ar_condicionado,

        @NotBlank Boolean freio,

        @NotBlank Boolean combustivel,

        @NotBlank Boolean documentos,

        @NotBlank Boolean oleo,

        @NotBlank MultipartFile imagem
        ) {
}
