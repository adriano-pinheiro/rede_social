package br.com.fiap.exercicio.api.rede_social.service;

import br.com.fiap.exercicio.api.rede_social.controller.exception.ControllerNotFoundException;
import br.com.fiap.exercicio.api.rede_social.dto.PostagemDTO;
import br.com.fiap.exercicio.api.rede_social.entities.Postagem;
import br.com.fiap.exercicio.api.rede_social.repository.PostagemRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public PostagemDTO findById(Long id){
       Postagem postagem = postagemRepository.findById(id)
               .orElseThrow(() ->
                    new ControllerNotFoundException("Postagem não encontrada"));
       return toDTO(postagem);
    }

    public PostagemDTO save(PostagemDTO postagemDTO){
       Postagem postagem = postagemRepository.save(toEntity(postagemDTO));
       postagem = postagemRepository.save(postagem);
       return toDTO(postagem);
    }

    public PostagemDTO update(Long id, PostagemDTO postagemDTO){
       try {
           Postagem postagem = postagemRepository.getOne(id);
           postagem.setTitulo(postagemDTO.titulo());
           postagem.setConteudo(postagemDTO.conteudo());
           postagem.setTags(postagemDTO.tags());
           postagem.setUsuario(postagemDTO.usuario());
           postagem.setCurtidas(postagemDTO.curtidas());
           postagem.setComentarios(postagemDTO.comentarios());
           postagem = postagemRepository.save(postagem);
           return toDTO(postagem);
       }catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Postagem não encontrada");
       }
    }

    public void delete(Long id){
        postagemRepository.deleteById(id);
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
