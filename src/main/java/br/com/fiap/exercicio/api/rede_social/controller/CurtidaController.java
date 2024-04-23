package br.com.fiap.exercicio.api.rede_social.controller;

import br.com.fiap.exercicio.api.rede_social.dto.CurtidaDTO;
import br.com.fiap.exercicio.api.rede_social.service.CurtidaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    private final CurtidaService curtidaService;

    public CurtidaController(CurtidaService curtidaService) {
        this.curtidaService = curtidaService;
    }

    @PostMapping
    public ResponseEntity<CurtidaDTO> save(@Valid @RequestBody CurtidaDTO curtidaDTO) {
        CurtidaDTO curtidaDTOSaved = curtidaService.save(curtidaDTO);
        return new ResponseEntity<>(curtidaDTOSaved, HttpStatus.CREATED);
    }

}
