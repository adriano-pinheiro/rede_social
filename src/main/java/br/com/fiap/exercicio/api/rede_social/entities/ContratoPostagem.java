package br.com.fiap.exercicio.api.rede_social.entities;

import java.util.List;

public interface ContratoPostagem {
    public void curtirPostagem(Usuario usuario);
    public void descurtirPostagem(Long id);
    public void comentarPostagem(Usuario usuario);
    public void descomentarPostagem(Long id);
}
