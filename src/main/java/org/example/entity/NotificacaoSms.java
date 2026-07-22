package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class NotificacaoSms extends NotificacaoBase {

    @Override
    public boolean enviar(String destinatario, String mensagem) {
        if(mensagem != null && mensagem.length() <= 160) {
            return true;
        } else {
            return false;
        }
    }
}
