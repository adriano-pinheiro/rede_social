package br.com.fiap.exercicio.api.rede_social.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        Long id,
        @NotBlank(message = "o nome não pode estar em branco.")
        String nome,
        @Email(message="E-mail inválido.")
        String email,
        String senha
) {}
