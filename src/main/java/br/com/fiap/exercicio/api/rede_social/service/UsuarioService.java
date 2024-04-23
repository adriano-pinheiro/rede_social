package br.com.fiap.exercicio.api.rede_social.service;

import br.com.fiap.exercicio.api.rede_social.controller.exception.ControllerNotFoundException;
import br.com.fiap.exercicio.api.rede_social.dto.UsuarioDTO;
import br.com.fiap.exercicio.api.rede_social.entities.Usuario;
import br.com.fiap.exercicio.api.rede_social.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<UsuarioDTO> findAll(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return  usuarios.map(this::toDTO);
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ControllerNotFoundException("Usuario não encontrado"));
        return toDTO(usuario);
    }

    public  UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.save(toEntity(usuarioDTO));
        usuario = usuarioRepository.save(usuario);
        return toDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario =  usuarioRepository.getOne(id);
            usuario.setNome(usuarioDTO.nome());
            usuario.setEmail(usuarioDTO.email());
            usuario.setSenha(usuarioDTO.senha());
            usuario = usuarioRepository.save(usuario);
            return toDTO(usuario);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Usuário não encontrado");
        }
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }

    private Usuario toEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.id(),
                usuarioDTO.nome(),
                usuarioDTO.email(),
                usuarioDTO.senha()
        );
    }

}
