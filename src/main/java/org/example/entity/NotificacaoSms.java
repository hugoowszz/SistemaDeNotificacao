package org.example.entity;

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
