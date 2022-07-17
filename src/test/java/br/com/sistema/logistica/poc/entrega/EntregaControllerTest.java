package br.com.sistema.logistica.poc.entrega;


import br.com.sistema.logistica.poc.entrega.dto.DadosGraficoResponse;
import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.entrega.dto.RelatorioEntregasResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class EntregaControllerTest {

    @Autowired
    private EntregaController entregaController;

    @MockBean
    private EntregaService entregaService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(entregaController).isNotNull();
    }

    @Test
    void deveListarEntregas() throws Exception {
        ResponseEntity response = entregaController.listarEntregas();
        Mockito.when(entregaService.dadosGraficoEntrega()).thenReturn(getDadosGraficoResponse());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode() );
    }

    @Test
    void deveListarEntregasComFiltro() throws Exception {
        ResponseEntity response = entregaController.listarEntregasComFiltro(getFiltro());
        Mockito.when(entregaService.dadosGraficoEntrega()).thenReturn(getDadosGraficoResponse());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode() );
    }

    @Test
    void deveListaEntregasComAtraso() throws Exception {
        ResponseEntity response = entregaController.listaEntregasComAtraso(getFiltro());
        Mockito.when(entregaService.dadosGraficoEntregaAtraso(any(FiltroRelatorioRequest.class))).thenReturn(getDadosGraficoResponse());
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode() );
    }

    private DadosGraficoResponse getDadosGraficoResponse(){
        DadosGraficoResponse dadosGraficoResponse = new DadosGraficoResponse();
        dadosGraficoResponse.setRelatorio(getRelatorioEntregasResponse());
        return dadosGraficoResponse;
    }

    private FiltroRelatorioRequest getFiltro(){
        FiltroRelatorioRequest filtroRelatorioRequest = new FiltroRelatorioRequest();
        filtroRelatorioRequest.setDataFim("2022-07-01");
        filtroRelatorioRequest.setDataFim("2022-07-30");
        return filtroRelatorioRequest;
    }

    private List<RelatorioEntregasResponse> getRelatorioEntregasResponse(){
        List<RelatorioEntregasResponse> relatorioEntregasResponses = new ArrayList<>();
        RelatorioEntregasResponse relatorioEntregasResponse = new RelatorioEntregasResponse();
        relatorioEntregasResponse.setDataEntrega("2022-07-10");
        relatorioEntregasResponse.setDiasAtraso(0L);
        relatorioEntregasResponse.setEstado("DF");
        relatorioEntregasResponse.setNumeroPedido("22335");
        relatorioEntregasResponses.add(relatorioEntregasResponse);

        return  relatorioEntregasResponses;
    }


}
