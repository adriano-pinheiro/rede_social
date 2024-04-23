package br.com.fiap.exercicio.api.rede_social.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;

    @ManyToOne
    private Usuario usuario;

    public Comentario() {}

    public Comentario(Long id, String comentario, Usuario usuario) {
        this.id = id;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

