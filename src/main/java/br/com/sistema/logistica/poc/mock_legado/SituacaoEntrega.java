package br.com.sistema.logistica.poc.mock_legado;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "SITUACAOENTREGA_LEGADO")
public class SituacaoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSituacaoEntrega;

    @Column(nullable = false)
    private String descSituacaoEntrega;
}
