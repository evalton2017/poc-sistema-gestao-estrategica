package br.com.sistema.logistica.poc.mock_legado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "PEDIDO_LEGADO")
public class PedidoLegado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;

    @Column(nullable = false)
    private LocalDate dataPedido;

    @Column(nullable = false)
    private BigDecimal valorPedido;

    @ManyToOne
    @JoinColumn(name = "idClienteLegado")
    private ClienteLegado cliente;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private ProdutoLegado produtoLegado;

    @Column(nullable = false)
    private Integer numeroPedido;
}
