package br.com.fiap.exercicio.api.rede_social.repository;

import br.com.fiap.exercicio.api.rede_social.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
