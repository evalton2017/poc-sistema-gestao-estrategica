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
@Table(name= "TRANSPORTADORA_LEGADO")
public class TransportadoraLegado {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idTransportadora;

    @Column(nullable = false)
    private String nomeTransportadora;

    @Column(nullable = false)
    private String cnpj;
}
