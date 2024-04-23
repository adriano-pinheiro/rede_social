package br.com.fiap.exercicio.api.rede_social.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_curtida")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Usuario usuario;

    public Curtida() {}

    public Curtida(long id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}


