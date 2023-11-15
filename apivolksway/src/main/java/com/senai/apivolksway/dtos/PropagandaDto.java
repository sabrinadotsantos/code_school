package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.BitSet;
import java.util.Date;
import java.util.UUID;

public record PropagandaDto(
    String titulo,
    String url,
    String descricao,
     String img,
     String  publico_alvo,
     Date data_limite,
     Float  preco,
    BitSet importancia,
     String  nome_tipo_propaganda
) {
}
