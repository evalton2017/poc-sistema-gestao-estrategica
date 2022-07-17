package br.com.sistema.logistica.poc.entrega.dto.legado;

import br.com.sistema.logistica.poc.mock_legado.TransportadoraLegado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportadoraLegadoResponse {

    private Long id;
    private String nome;

    public static TransportadoraLegadoResponse of(TransportadoraLegado transportadoraLegado){
        return TransportadoraLegadoResponse
                .builder()
                .id(transportadoraLegado.getIdTransportadora())
                .nome(transportadoraLegado.getNomeTransportadora())
                .build();
    }
}
