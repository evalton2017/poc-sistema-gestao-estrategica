package br.com.sistema.logistica.poc.entrega.repository;

import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.util.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntregaRepositoryImplTest {

    @Autowired
    EntregaRepository entregaRepository;

    @Test
    void deveRetornarDadosGraficoEntrega() throws Exception {
        Assertions.assertNotNull(entregaRepository.findByEntregaByDataPedido(DateUtil.getInicioAnoVigente(), DateUtil.getFinalAnoVigente()));
    }

    @Test
    void findByEntrega() throws Exception {
        Assertions.assertNotNull(entregaRepository.findByEntrega(getFiltro()));
    }

    private FiltroRelatorioRequest getFiltro(){
        FiltroRelatorioRequest filtroRelatorioRequest = new FiltroRelatorioRequest();
        filtroRelatorioRequest.setDataInicio("2022-07-01");
        filtroRelatorioRequest.setDataFim("2022-07-30");
        filtroRelatorioRequest.setIdTransportadora(1L);
        filtroRelatorioRequest.setNumeroPedido(2222);
        filtroRelatorioRequest.setSituacao(1L);
        return filtroRelatorioRequest;
    }
}
