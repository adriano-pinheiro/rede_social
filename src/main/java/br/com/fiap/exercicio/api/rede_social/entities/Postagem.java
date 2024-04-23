package br.com.fiap.exercicio.api.rede_social.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_postagem")
public class Postagem implements ContratoPostagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudo;
    private String tags;
    @ManyToOne
    private Usuario usuario;

    @OneToMany
    private List<Curtida> curtidas; // = new ArrayList<>();
    @OneToMany
    private List<Comentario> comentarios;// = new ArrayList<>();

    public Postagem() {}

    public Postagem(Long id, String titulo, String conteudo, String tags, Usuario usuario, List<Curtida> curtidas, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tags = tags;
        this.usuario = usuario;
        this.curtidas = curtidas;
        this.comentarios = comentarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return id == postagem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Postagem{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", tags='" + tags + '\'' +
                ", usuario=" + usuario +
                ", curtidas=" + curtidas +
                ", comentarios=" + comentarios +
                '}';
    }

    @Override
    public void curtirPostagem(Usuario usuario) {
        Curtida curtida = new Curtida();
        curtida.setId(1);
        curtida.setUsuario(usuario);
        curtidas.add(curtida);
    }

    @Override
    public void descurtirPostagem(Long id) {
        for(Curtida curtida : curtidas) {
            if(curtida.getId() == id) {
                curtidas.remove(curtida);
            }
        }
    }

    @Override
    public void comentarPostagem(Usuario usuario) {
        Comentario comentario = new Comentario();
        comentario.setId(1);
        comentario.setComentario("Comentario de postagem");
        comentario.setUsuario(usuario);
        comentarios.add(comentario);
    }

    @Override
    public void descomentarPostagem(Long id) {
        for(Comentario comentario : comentarios) {
            if(comentario.getId() == id) {
                comentarios.remove(comentario);
            }
        }
    }

}
