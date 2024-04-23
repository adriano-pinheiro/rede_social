package br.com.fiap.exercicio.api.rede_social.dto;

import br.com.fiap.exercicio.api.rede_social.entities.Comentario;
import br.com.fiap.exercicio.api.rede_social.entities.Curtida;
import br.com.fiap.exercicio.api.rede_social.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PostagemDTO(
        Long id,
        @NotBlank(message = "o titulo não pode estar em branco.")
        String titulo,
        @NotBlank(message = "o conteudo não pode estar em branco.")
        String conteudo,
        String tags,
        Usuario usuario,
        List<Curtida>curtidas,
        List<Comentario> comentarios
) {}
