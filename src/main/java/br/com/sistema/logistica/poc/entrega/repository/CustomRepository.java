package br.com.sistema.logistica.poc.entrega.repository;

import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.mock_legado.EntregaLegado;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomRepository {

    List<EntregaLegado> findByEntrega(FiltroRelatorioRequest filtro);

    List<EntregaLegado> findByEntregaByDataPedido(@Param("inicio") String inicio,
                                                  @Param("inicio") String fim);
}
