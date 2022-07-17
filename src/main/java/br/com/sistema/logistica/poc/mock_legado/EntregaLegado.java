package br.com.sistema.logistica.poc.mock_legado;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "ENTREGA_LEGADO", schema = "public")
public class EntregaLegado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEntrega;

    @ManyToOne
    @JoinColumn(name = "idSituacaoEntrega")
    private SituacaoEntrega situacaoEntrega;

    @ManyToOne
    @JoinColumn(name = "idTransportadora")
    private TransportadoraLegado transportadoraLegado;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private PedidoLegado pedidoLegado;

    private String numeroRastreio;

    @Column(nullable = false)
    @JsonProperty("dataEntregaPrevista")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntregaPrevista;

    @Column(nullable = true)
    @JsonProperty("dataEntregaEfetiva")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntregaEfetiva;

    @Column(nullable = false)
    @JsonProperty("dataSaida")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataSaida;

    @Column(nullable = true)
    @JsonProperty("dataDevolucao")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataDevolucao;

    private String estado;

    private String cidade;


}
