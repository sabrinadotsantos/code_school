package com.senai.apivolksway.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank @Email String email,

        @NotBlank String senha
) {
}
