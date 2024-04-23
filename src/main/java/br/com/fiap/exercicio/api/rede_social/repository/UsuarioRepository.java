package br.com.fiap.exercicio.api.rede_social.repository;

import br.com.fiap.exercicio.api.rede_social.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
