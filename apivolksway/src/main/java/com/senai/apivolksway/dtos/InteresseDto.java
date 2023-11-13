package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.BitSet;
import java.util.UUID;

public record InteresseDto(


        @NotNull UUID id_propaganda,
        @NotNull UUID id_usuario,



        BitSet email
        //meio_contato_email
) {


}
