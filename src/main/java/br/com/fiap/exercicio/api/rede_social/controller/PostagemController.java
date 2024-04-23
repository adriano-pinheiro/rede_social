package br.com.fiap.exercicio.api.rede_social.controller;

import br.com.fiap.exercicio.api.rede_social.dto.PostagemDTO;
import br.com.fiap.exercicio.api.rede_social.service.PostagemService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<PostagemDTO> findById(@PathVariable Long id) {
        PostagemDTO postagemDTO = postagemService.findById(id);
        return ResponseEntity.ok(postagemDTO);
    }

    @PostMapping
    public ResponseEntity<PostagemDTO> save(@Valid @RequestBody PostagemDTO postagemDTO) {
        PostagemDTO postagemDTOSaved = postagemService.save(postagemDTO);
        return new ResponseEntity<>(postagemDTOSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <PostagemDTO> update(@PathVariable Long id, @RequestBody PostagemDTO postagemDTO) {
        PostagemDTO postagemDTOUpdated = postagemService.update(id, postagemDTO);
        return ResponseEntity.ok(postagemDTOUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postagemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
