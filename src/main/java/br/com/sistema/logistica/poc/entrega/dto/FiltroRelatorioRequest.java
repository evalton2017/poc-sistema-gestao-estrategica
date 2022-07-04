package br.com.sistema.logistica.poc.entrega.dto;

import lombok.Data;

@Data
public class FiltroRelatorioRequest {

    private Long idTransportadora;
    private Long situacao;
    private Integer numeroPedido;
    private String dataInicio;
    private String dataFim;


}
