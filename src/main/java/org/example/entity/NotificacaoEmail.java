package org.example.entity;

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
