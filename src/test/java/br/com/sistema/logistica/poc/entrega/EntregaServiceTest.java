package br.com.sistema.logistica.poc.entrega;

import br.com.sistema.logistica.poc.config.exception.ValidationException;
import br.com.sistema.logistica.poc.entrega.dto.DadosGraficoResponse;
import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.entrega.dto.RelatorioEntregasResponse;
import br.com.sistema.logistica.poc.entrega.repository.EntregaRepository;
import br.com.sistema.logistica.poc.mock_legado.EntregaLegado;
import br.com.sistema.logistica.poc.mock_legado.PedidoLegado;
import br.com.sistema.logistica.poc.mock_legado.SituacaoEntrega;
import br.com.sistema.logistica.poc.mock_legado.TransportadoraLegado;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class EntregaServiceTest {

    private static final String ENTREGUE = "ENTREGUE";
    private static final String A_CAMINHO = "A CAMINHO";
    private static final String SAIU_PARA_ENTREGA = "SAIU PARA ENTREGA";
    private static final String DEVOLVIDO = "DEVOLVIDO";
    private static final String ATRASO = "ATRASO";

    @MockBean
    EntregaRepository entregaRepository;

    @Autowired
    EntregaService entregaService;

    @Test
    void deveRetornarDadosGraficoEntrega() throws Exception {
        Mockito.when(entregaRepository.findByEntregaByDataPedido(any(String.class), any(String.class))).thenReturn(getEntregaLegado());
        Assertions.assertNotNull(entregaService.dadosGraficoEntrega());
    }

    @Test
    void deveRetornarDadosGraficoEntregaFiltroa() throws Exception {
        Mockito.when(entregaRepository.findByEntrega(any(FiltroRelatorioRequest.class))).thenReturn(getEntregaLegado());
        Assertions.assertNotNull(entregaService.dadosGraficoEntregaFiltro(getFiltro()));
    }

    @Test
    void deveRetornarDadosGraficoEntregaAtraso() throws Exception {
        Mockito.when(entregaRepository.findByEntrega(any(FiltroRelatorioRequest.class))).thenReturn(getEntregaLegadoAtraso());
        Assertions.assertNotNull(entregaService.dadosGraficoEntregaAtraso(getFiltro()));
    }

    @Test
    void deveRetornarDadosGraficoEntregaAtrasoErroData() {
        Mockito.when(entregaRepository.findByEntrega(any(FiltroRelatorioRequest.class))).thenReturn(getEntregaLegadoErro());
        Assert.assertThrows(ValidationException.class,() -> entregaService.dadosGraficoEntregaAtraso(getFiltroErro()));
    }

    private DadosGraficoResponse getDadosGraficoResponse(){
        DadosGraficoResponse dadosGraficoResponse = new DadosGraficoResponse();
        dadosGraficoResponse.setRelatorio(getRelatorioEntregasResponse());
        return dadosGraficoResponse;
    }

    private FiltroRelatorioRequest getFiltro(){
        FiltroRelatorioRequest filtroRelatorioRequest = new FiltroRelatorioRequest();
        filtroRelatorioRequest.setDataInicio("2022-07-01");
        filtroRelatorioRequest.setDataFim("2022-07-30");
        return filtroRelatorioRequest;
    }

    private FiltroRelatorioRequest getFiltroErro(){
        FiltroRelatorioRequest filtroRelatorioRequest = new FiltroRelatorioRequest();
        filtroRelatorioRequest.setDataInicio("01/07/2022");
        filtroRelatorioRequest.setDataFim("30/07/2022");
        return filtroRelatorioRequest;
    }

    private List<RelatorioEntregasResponse> getRelatorioEntregasResponse(){
        List<RelatorioEntregasResponse> relatorioEntregasResponses = new ArrayList<>();
        RelatorioEntregasResponse relatorioEntregasResponse = new RelatorioEntregasResponse();
        relatorioEntregasResponse.setDataEntrega("2022-07-10");
        relatorioEntregasResponse.setDiasAtraso(0L);
        relatorioEntregasResponse.setEstado("Distrito Federal");
        relatorioEntregasResponse.setNumeroPedido("22335");
        relatorioEntregasResponses.add(relatorioEntregasResponse);

        return  relatorioEntregasResponses;
    }

    private List<EntregaLegado> getEntregaLegado(){
        List<EntregaLegado> entregas = new ArrayList<>();
        EntregaLegado entregaLegado = new EntregaLegado();
        entregaLegado.setIdEntrega(1L);
        entregaLegado.setEstado("Distrito Federal");
        //SITUAÇÃO
        SituacaoEntrega situacaoEntrega = new SituacaoEntrega();
        situacaoEntrega.setIdSituacaoEntrega(3L);
        situacaoEntrega.setDescSituacaoEntrega(A_CAMINHO);
        entregaLegado.setSituacaoEntrega(situacaoEntrega);
        //TRANSPORTADORA
        TransportadoraLegado transportadoraLegado = new TransportadoraLegado();
        transportadoraLegado.setNomeTransportadora("Teste");
        entregaLegado.setTransportadoraLegado(transportadoraLegado);
        //PEDIDO
        PedidoLegado pedidoLegado = new PedidoLegado();
        pedidoLegado.setNumeroPedido(23556);
        entregaLegado.setPedidoLegado(pedidoLegado);
        LocalDateTime dataSaida  = LocalDateTime.of(2022,07,04,10,20);
        entregaLegado.setDataSaida(dataSaida);

        entregas.add(entregaLegado);
        return entregas;
    }

    private List<EntregaLegado> getEntregaLegadoAtraso(){
        List<EntregaLegado> entregas = new ArrayList<>();
        EntregaLegado entregaLegado = new EntregaLegado();
        entregaLegado.setIdEntrega(1L);
        entregaLegado.setEstado("Distrito Federal");
        //SITUAÇÃO
        SituacaoEntrega situacaoEntrega = new SituacaoEntrega();
        situacaoEntrega.setIdSituacaoEntrega(3L);
        situacaoEntrega.setDescSituacaoEntrega(A_CAMINHO);
        entregaLegado.setSituacaoEntrega(situacaoEntrega);
        //TRANSPORTADORA
        TransportadoraLegado transportadoraLegado = new TransportadoraLegado();
        transportadoraLegado.setNomeTransportadora("Teste");
        entregaLegado.setTransportadoraLegado(transportadoraLegado);
        //PEDIDO
        PedidoLegado pedidoLegado = new PedidoLegado();
        pedidoLegado.setNumeroPedido(23556);
        entregaLegado.setPedidoLegado(pedidoLegado);
        LocalDateTime dataSaida  = LocalDateTime.of(2022,07,05,10,20);
        LocalDateTime dataEntrega  = LocalDateTime.of(2022,07,15,10,20);
        LocalDateTime dataEstimaEntrega  = LocalDateTime.of(2022,07,10,10,20);
        entregaLegado.setDataSaida(dataSaida);
        entregaLegado.setDataEntregaEfetiva(dataEntrega);
        entregaLegado.setDataEntregaPrevista(dataEstimaEntrega);

        EntregaLegado entregaLegado_ = new EntregaLegado();
        entregaLegado_.setIdEntrega(1L);
        entregaLegado_.setEstado("São Paulo");
        //SITUAÇÃO
        SituacaoEntrega situacaoEntrega_ = new SituacaoEntrega();
        situacaoEntrega_.setIdSituacaoEntrega(3L);
        situacaoEntrega_.setDescSituacaoEntrega(A_CAMINHO);
        entregaLegado_.setSituacaoEntrega(situacaoEntrega_);
        //TRANSPORTADORA
        TransportadoraLegado transportadoraLegado_ = new TransportadoraLegado();
        transportadoraLegado_.setNomeTransportadora("Teste");
        entregaLegado_.setTransportadoraLegado(transportadoraLegado_);
        //PEDIDO
        PedidoLegado pedidoLegado_ = new PedidoLegado();
        pedidoLegado_.setNumeroPedido(23556);
        entregaLegado_.setPedidoLegado(pedidoLegado_);
        LocalDateTime dataSaida_  = LocalDateTime.of(2022,07,01,10,20);
        LocalDateTime dataEntrega_  = LocalDateTime.of(2022,07,16,10,20);
        LocalDateTime dataEstimaEntrega_  = LocalDateTime.of(2022,07,9,10,20);
        entregaLegado_.setDataSaida(dataSaida_);
        entregaLegado_.setDataEntregaEfetiva(dataEntrega_);
        entregaLegado_.setDataEntregaPrevista(dataEstimaEntrega_);

        entregas.add(entregaLegado_);
        return entregas;
    }

    private List<EntregaLegado> getEntregaLegadoErro(){
        List<EntregaLegado> entregas = new ArrayList<>();
        EntregaLegado entregaLegado = new EntregaLegado();
        entregaLegado.setIdEntrega(1L);
        entregaLegado.setEstado("Distrito Federal");
        //SITUAÇÃO
        SituacaoEntrega situacaoEntrega = new SituacaoEntrega();
        situacaoEntrega.setIdSituacaoEntrega(3L);
        situacaoEntrega.setDescSituacaoEntrega(A_CAMINHO);
        entregaLegado.setSituacaoEntrega(situacaoEntrega);
        //TRANSPORTADORA
        TransportadoraLegado transportadoraLegado = new TransportadoraLegado();
        transportadoraLegado.setNomeTransportadora("Teste");
        entregaLegado.setTransportadoraLegado(transportadoraLegado);
        //PEDIDO
        PedidoLegado pedidoLegado = new PedidoLegado();
        pedidoLegado.setNumeroPedido(23556);
        entregaLegado.setPedidoLegado(pedidoLegado);
        LocalDateTime hoje = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        entregaLegado.setDataSaida(hoje);
        entregaLegado.setDataEntregaEfetiva(hoje);

        entregas.add(entregaLegado);
        return entregas;
    }
}
