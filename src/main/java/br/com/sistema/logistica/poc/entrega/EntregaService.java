package br.com.sistema.logistica.poc.entrega;

import br.com.sistema.logistica.poc.config.exception.ValidationException;
import br.com.sistema.logistica.poc.entrega.dto.DadosGraficoResponse;
import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.entrega.dto.RelatorioEntregasResponse;
import br.com.sistema.logistica.poc.entrega.dto.RelatorioTransportadoraResponse;
import br.com.sistema.logistica.poc.entrega.repository.EntregaRepository;
import br.com.sistema.logistica.poc.util.DateUtil;
import br.com.sistema.logistica.poc.util.Parametros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class EntregaService {

    private static final String ENTREGUE = "ENTREGUE";
    private static final String A_CAMINHO = "A CAMINHO";
    private static final String DEVOLVIDO = "DEVOLVIDO";

    @Autowired
    private EntregaRepository entregaRepository;

    public  DadosGraficoResponse dadosGraficoEntrega(){
        DadosGraficoResponse dadosGraficoResponse = new DadosGraficoResponse();
        List<RelatorioEntregasResponse> entregas =   entregaRepository.findByEntregaByDataPedido(DateUtil.getInicioAnoVigente(),
                DateUtil.getFinalAnoVigente())
                .stream()
                .map(RelatorioEntregasResponse::of)
                .collect(Collectors.toList());

        dadosGraficoResponse.setConcluidas(entregasFinalizadas(entregas, ENTREGUE));
        dadosGraficoResponse.setEmAndamento(entregasFinalizadas(entregas, A_CAMINHO));
        dadosGraficoResponse.setDevolvidas(entregasFinalizadas(entregas, DEVOLVIDO));
        dadosGraficoResponse.setLocais(entregaPorLocalidade(entregas));
        return dadosGraficoResponse;
    }

    private List<RelatorioTransportadoraResponse> entregaPorLocalidade(List<RelatorioEntregasResponse> entregas){

        List<RelatorioTransportadoraResponse> locais = new ArrayList<>();

        for(int i=0;i<Parametros.LISTA_ESTADOS().size(); i++){
            int finalI = i;
            var entregasPorEstadoFiltro = entregas.stream().filter(e -> e.getEstado().equals(Parametros.LISTA_ESTADOS().get(finalI)))
                    .collect(Collectors.toList());

            Map<String, Long> agrupamentoEntregas = entregasPorEstadoFiltro.stream().collect(Collectors.groupingBy(RelatorioEntregasResponse::getEstado, Collectors.counting()));

            agrupamentoEntregas.forEach((k,v) -> {
                RelatorioTransportadoraResponse finalizada = new RelatorioTransportadoraResponse();
                finalizada.setNomeTransportadora(k);
                finalizada.setQuantidade(v.intValue());
                locais.add(finalizada);
            });
        }



        return locais;

    }

    private List<RelatorioTransportadoraResponse> entregasFinalizadas(List<RelatorioEntregasResponse> entregas, String filtro){

        List<RelatorioTransportadoraResponse> finalizadas = new ArrayList<>();

        var entregasFinalizadas = entregas.stream().filter(e -> e.getSituacaoEntrega().equals(filtro)).collect(Collectors.toList());

        agruparEntregaFinalizada(finalizadas, entregasFinalizadas);

        return finalizadas;

    }

    private void agruparEntregaFinalizada(List<RelatorioTransportadoraResponse> finalizadas, List<RelatorioEntregasResponse> entregasFinalizadas) {
        Map<String, Long> agrupamentoEntregas = agrupaEntregas(entregasFinalizadas);

        agrupamentoEntregas.forEach((k,v) -> {
            RelatorioTransportadoraResponse finalizada = new RelatorioTransportadoraResponse();
            finalizada.setNomeTransportadora(k);
            finalizada.setQuantidade(v.intValue());
            finalizadas.add(finalizada);
        });
    }


    public  DadosGraficoResponse dadosGraficoEntregaFiltro(FiltroRelatorioRequest filtro){
        DadosGraficoResponse dadosGraficoResponse = new DadosGraficoResponse();
        List<RelatorioEntregasResponse> entregas =   entregaRepository.findByEntrega(filtro)
                .stream()
                .map(RelatorioEntregasResponse::of)
                .collect(Collectors.toList());

        dadosGraficoResponse.setConcluidas(entregasFinalizadas(entregas, ENTREGUE));
        dadosGraficoResponse.setLocais(entregaPorLocalidade(entregas));
        dadosGraficoResponse.setRelatorio(entregas);
        return dadosGraficoResponse;
    }


    public  DadosGraficoResponse dadosGraficoEntregaAtraso(FiltroRelatorioRequest filtro) {
        DadosGraficoResponse dadosGraficoResponse = new DadosGraficoResponse();
        List<RelatorioEntregasResponse> entregas =   entregaRepository.findByEntrega(filtro)
                .stream()
                .map(RelatorioEntregasResponse::of)
                .collect(Collectors.toList());

        try {
            entregasAtrasadas(entregas, dadosGraficoResponse);
        } catch (ParseException e) {
            throw new ValidationException("Erro ao converter data");
        }
        return dadosGraficoResponse;
    }

    private void  entregasAtrasadas(List<RelatorioEntregasResponse> entregas, DadosGraficoResponse dadosGraficoResponse) throws ParseException {
        List<RelatorioTransportadoraResponse> atrasadas = new ArrayList<>();

        var entregasAtrasadas = filtrarEntregasAtradas(entregas);

        agruparEntregaFinalizada(atrasadas, entregasAtrasadas);
        dadosGraficoResponse.setRelatorio(entregasAtrasadas);
        dadosGraficoResponse.setAtrasadas(atrasadas);


    }

    private Map<String, Long> agrupaEntregas(List<RelatorioEntregasResponse> entregas){
        return entregas.stream().collect(Collectors.groupingBy(RelatorioEntregasResponse::getNomeTransportadora, Collectors.counting()));
    }

    private List<RelatorioEntregasResponse> filtrarEntregasAtradas(List<RelatorioEntregasResponse> entregas) throws ParseException {
        List<RelatorioEntregasResponse> relatorioEntregasResponses = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        TimeUnit time = TimeUnit.DAYS;
        Date hoje = new Date();
        Date referencia;
        for(RelatorioEntregasResponse relatorio: entregas){
            if(relatorio.getDataEntrega() != null && !relatorio.getDataEntrega().equals("--")){
                referencia = format.parse(relatorio.getDataEntregaEstimada());
                if(referencia.before(hoje)){
                    relatorioEntregasResponses.add(relatorio);
                    long diff = hoje.getTime() - referencia.getTime();
                    relatorio.setDiasAtraso(time.convert(diff, TimeUnit.MILLISECONDS));
                }
            }
        }

        return relatorioEntregasResponses;
    }

}
