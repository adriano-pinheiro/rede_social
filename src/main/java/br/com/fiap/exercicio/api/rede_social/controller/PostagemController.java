package br.com.fiap.exercicio.api.rede_social.controller;

import br.com.fiap.exercicio.api.rede_social.dto.PostagemDTO;
import br.com.fiap.exercicio.api.rede_social.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService postagemService;

    @Autowired
    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @GetMapping
    public ResponseEntity<Page<PostagemDTO>> findAll(
            @PageableDefault(page=0, size=10, sort = "titulo") Pageable pageable
    ) {
        Page<PostagemDTO> postagemDTOS = postagemService.findAll(pageable);
        return ResponseEntity.ok(postagemDTOS);
    }

}
