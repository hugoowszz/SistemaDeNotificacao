package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NotificacaoEmail extends NotificacaoBase{
    @Override
    public boolean enviar(String destinatario, String mensagem) {
        if(destinatario != null && destinatario.contains("@") && destinatario.contains(".")) {
            return true;
        } else {
            return false;
        }
    }
}
