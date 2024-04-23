package br.com.fiap.exercicio.api.rede_social.service;

import br.com.fiap.exercicio.api.rede_social.dto.CurtidaDTO;
import br.com.fiap.exercicio.api.rede_social.entities.Curtida;
import br.com.fiap.exercicio.api.rede_social.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtidaService {

    private final CurtidaRepository curtidaRepository;

    @Autowired
    public CurtidaService(CurtidaRepository curtidaRepository) {
        this.curtidaRepository = curtidaRepository;
    }

    public CurtidaDTO save(CurtidaDTO curtidaDTO) {
        Curtida curtida = curtidaRepository.save(toEntity(curtidaDTO));
        curtida = curtidaRepository.save(curtida);
        return toDTO(curtida);
    }

    private CurtidaDTO toDTO(Curtida curtida) {
        return  new CurtidaDTO(
                curtida.getId(),
                curtida.getUsuario()
        );
    }

    private Curtida toEntity(CurtidaDTO curtidaDTO) {
        return new Curtida(
                curtidaDTO.id(),
                curtidaDTO.usuario()
        );
    }

}
