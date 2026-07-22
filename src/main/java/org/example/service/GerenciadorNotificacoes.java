package org.example.service;

import org.example.config.exception.ReciboNaoEncontradoException;
import org.example.entity.CanalNotificacao;
import org.example.entity.FiltroAuditoria;
import org.example.entity.ReciboImutavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class GerenciadorNotificacoes {

    private final List<CanalNotificacao> canais;

    public GerenciadorNotificacoes(List<CanalNotificacao> canais) {
        this.canais = canais;
    }

    public List<ReciboImutavel> disparar(String destinatario, String mensagem) {
        List<ReciboImutavel> recibos = new ArrayList<>();
        int idTransacao = 1;

        for(CanalNotificacao canal : this.canais){
            boolean sucesso = canal.enviar(destinatario, mensagem);
            String nomeDoCanal = canal.getClass().getSimpleName();
            ReciboImutavel recibo = new ReciboImutavel(idTransacao, destinatario, nomeDoCanal, sucesso, LocalDateTime.now());
            recibos.add(recibo);
            idTransacao++;
        }
        return recibos;
    }

    public Set<ReciboImutavel> verificar(List<ReciboImutavel> recibos) {
        Set<ReciboImutavel> recibosVerificados = new HashSet<>();
        Set<Integer> idsVistos = new HashSet<>();

        for(ReciboImutavel recibo : recibos) {
            if(!idsVistos.contains(recibo.getId())) {
                recibosVerificados.add(recibo);
                idsVistos.add(recibo.getId());
            }
        }

        return recibosVerificados;
    }

    public Map<Boolean ,Set<ReciboImutavel>> agruparPorStatus(List<ReciboImutavel> recibos) {
        Map<Boolean ,Set<ReciboImutavel>> mapaAgrupado = new HashMap<>();
        Set<ReciboImutavel> recibosSucesso = new HashSet<>();
        Set<ReciboImutavel> recibosFalha = new HashSet<>();
        for(ReciboImutavel recibo : recibos) {
            if(recibo.getSucesso()){
                recibosSucesso.add(recibo);
            } else {
                recibosFalha.add(recibo);
            }
        }
        mapaAgrupado.put(true, recibosSucesso);
        mapaAgrupado.put(false, recibosFalha);
        return mapaAgrupado;
    }

    public ReciboImutavel buscarRecibo(Integer idTransacao, List<ReciboImutavel> recibos) {
        Map<Integer, ReciboImutavel> recibosMap = new HashMap<>();
        for(ReciboImutavel recibo : recibos){
            recibosMap.putIfAbsent(recibo.getId(), recibo);
        }
        return Optional.ofNullable(recibosMap.get(idTransacao)).orElseThrow(() -> new ReciboNaoEncontradoException("Recibo não encontrado para o id: " + idTransacao));
    }

    public List<String> obterEmailsSucesso(List<ReciboImutavel> recibos) {
        return recibos.stream().filter(recibo -> recibo.getSucesso()).filter(recibo -> recibo.getCanal().contains("NotificacaoEmail")).map(recibo -> recibo.getDestinatario()).toList();
    }

    public Map<String, Double> calcularCusto(List<ReciboImutavel> recibos) {
        Map<String, Double> custos = new HashMap<>(Map.of(
                "Email", 0.0,
                "Sms", 0.0,
                "Push", 0.0
        ));

        for(ReciboImutavel recibo : recibos) {
            if(recibo.getSucesso())
            {
                switch (recibo.getCanal()) {
                    case "NotificacaoEmail" -> custos.put("Email", custos.get("Email") + 0.01);
                    case "NotificacaoSms" -> custos.put("Sms", custos.get("Sms") + 0.05);
                    case "NotificacaoPush" -> custos.put("Push", custos.get("Push") + 0.02);
                }
            }
        }
        return custos;
    }

    public List<String> obterContatosUnicos(List<ReciboImutavel> recibos) {
        return recibos.stream().flatMap(recibo -> Arrays.stream(recibo.getDestinatario().split(","))).map(String::trim).distinct().toList();
    }

    public List<ReciboImutavel> ordenarLista(List<ReciboImutavel> recibos) {
        return recibos.stream().sorted(Comparator.comparing(ReciboImutavel::getDataHora).reversed()).toList();
    }

    public List<ReciboImutavel> filtrarLista(List<ReciboImutavel> recibos, FiltroAuditoria filtro) {
        return recibos.stream().filter(recibo -> filtro.filtrar(recibo)).toList();
    }
}