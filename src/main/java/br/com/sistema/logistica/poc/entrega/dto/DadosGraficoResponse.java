package br.com.sistema.logistica.poc.entrega.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosGraficoResponse {

    private List<RelatorioTransportadoraResponse> concluidas;
    private List<RelatorioTransportadoraResponse> emAndamento;
    private List<RelatorioTransportadoraResponse> devolvidas;
    private List<RelatorioTransportadoraResponse> locais;
    private List<RelatorioTransportadoraResponse> atrasadas;
    private List<RelatorioEntregasResponse> relatorio;


}
