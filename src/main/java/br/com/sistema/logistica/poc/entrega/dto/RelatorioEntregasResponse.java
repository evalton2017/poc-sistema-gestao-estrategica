package br.com.sistema.logistica.poc.entrega.dto;

import br.com.sistema.logistica.poc.moc_legado.EntregaLegado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioEntregasResponse {

    private String nomeTransportadora;
    private String numeroPedido;
    private String dataEntregaEstimada;
    private Long diasAtraso;
    private String situacaoEntrega;
    private String dataDevolucao;
    private String dataEntrega;
    private String dataSaida;
    private String estado;


    public static RelatorioEntregasResponse of(EntregaLegado entregaLegado){
        return RelatorioEntregasResponse
                .builder()
                .nomeTransportadora(entregaLegado.getTransportadoraLegado().getNomeTransportadora())
                .numeroPedido(entregaLegado.getPedidoLegado().getNumeroPedido().toString())
                .situacaoEntrega(entregaLegado.getSituacaoEntrega().getDescSituacaoEntrega())
                .dataEntrega(entregaLegado.getDataEntregaEfetiva() != null ? entregaLegado.getDataEntregaEfetiva().toString() : "--")
                .dataDevolucao(entregaLegado.getDataDevolucao() != null ? entregaLegado.getDataDevolucao().toString() : "--")
                .dataEntregaEstimada(entregaLegado.getDataEntregaPrevista() != null ?entregaLegado.getDataEntregaPrevista().toString() : "--" )
                .dataSaida(entregaLegado.getDataSaida() != null ? entregaLegado.getDataSaida().toString() : "--")
                .diasAtraso(0L)
                .estado(entregaLegado.getEstado())
                .build();
    }
}
