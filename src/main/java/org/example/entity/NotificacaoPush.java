package org.example.entity;

public class NotificacaoPush extends NotificacaoBase{
    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    private String tokenDispositivo;

    @Override
    public boolean enviar(String destinatario, String mensagem) {
        if(this.tokenDispositivo != null && this.tokenDispositivo.length() >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
