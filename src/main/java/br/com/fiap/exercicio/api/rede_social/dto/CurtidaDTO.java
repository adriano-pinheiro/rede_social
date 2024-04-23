package br.com.fiap.exercicio.api.rede_social.dto;

import br.com.fiap.exercicio.api.rede_social.entities.Usuario;

public record CurtidaDTO(
        Long id,
        Usuario usuario
) {
}
