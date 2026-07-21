package org.example.entity;

public abstract class NotificacaoBase implements CanalNotificacao {
    private String id;
    private String nomeCanal;
    private int quantidadeTentativas;

    public void setId(String id) {
        this.id = id;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public void setQuantidadeTentativas(int quantidadeTentativas) {
        this.quantidadeTentativas = quantidadeTentativas;
    }

    public String getId() {
        return id;
    }

    public String getNomeCanal() {
        return nomeCanal;
    }

    public int getQuantidadeTentativas() {
        return quantidadeTentativas;
    }
}
