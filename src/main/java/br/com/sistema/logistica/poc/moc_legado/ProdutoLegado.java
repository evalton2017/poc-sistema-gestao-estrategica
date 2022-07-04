package br.com.sistema.logistica.poc.moc_legado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "PRODUTO_LEGADO")
public class ProdutoLegado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProduto;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="quantidade")
    private Integer quantidade;

}
