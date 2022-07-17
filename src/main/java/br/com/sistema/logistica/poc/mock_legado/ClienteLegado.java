package br.com.sistema.logistica.poc.mock_legado;

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
@Table(name= "CLIENTE_LEGADO")
public class ClienteLegado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClienteLegado;

    @Column(nullable = false)
    private String nomeCliente;

    @Column(nullable = false)
    private String cpfCnpj;
}
