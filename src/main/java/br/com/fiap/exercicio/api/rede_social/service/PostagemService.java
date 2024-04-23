package br.com.fiap.exercicio.api.rede_social.service;

import br.com.fiap.exercicio.api.rede_social.dto.PostagemDTO;
import br.com.fiap.exercicio.api.rede_social.entities.Postagem;
import br.com.fiap.exercicio.api.rede_social.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

   @Autowired
    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public Page<PostagemDTO> findAll(Pageable pageable){
        Page<Postagem> postagens = postagemRepository.findAll(pageable);
        return  postagens.map(this::toDTO);
    }

    private PostagemDTO toDTO(Postagem postagem) {
        return new PostagemDTO(
                postagem.getId(),
                postagem.getTitulo(),
                postagem.getConteudo(),
                postagem.getTags(),
                postagem.getUsuario(),
                postagem.getCurtidas(),
                postagem.getComentarios()
        );
    }

    private Postagem toEntity(PostagemDTO postagemDTO) {
        return new Postagem(
                postagemDTO.id(),
                postagemDTO.titulo(),
                postagemDTO.conteudo(),
                postagemDTO.tags(),
                postagemDTO.usuario(),
                postagemDTO.curtidas(),
                postagemDTO.comentarios()
        );
    }

}
