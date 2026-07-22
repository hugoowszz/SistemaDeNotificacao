package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NotificacaoPush extends NotificacaoBase{
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
