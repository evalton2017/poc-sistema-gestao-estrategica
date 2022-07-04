package br.com.sistema.logistica.poc.entrega.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioTransportadoraResponse {

    private String nomeTransportadora;
    private Integer quantidade;
}
