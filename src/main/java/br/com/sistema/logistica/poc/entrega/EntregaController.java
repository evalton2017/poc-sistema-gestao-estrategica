package br.com.sistema.logistica.poc.entrega;

import br.com.sistema.logistica.poc.entrega.dto.DadosGraficoResponse;
import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.entrega.dto.RelatorioEntregasResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    EntregaRepository entregaRepository;

    @Autowired
    EntregaService entregaService;

    @ApiOperation(value = "Metodo responsavel por retornar todas as entregas do ano corrente")
    @GetMapping()
    public DadosGraficoResponse listarEntregas(){
      return entregaService.dadosGraficoEntrega();
    }

    @ApiOperation(value = "Metodo responsavel por retornar todas as entregas  do mês corrente(default) ou filtro")
    @GetMapping("/filtro")
    public DadosGraficoResponse listarEntregasComFiltro(FiltroRelatorioRequest filtroRelatorioRequest){
         return entregaService.dadosGraficoEntregaFiltro(filtroRelatorioRequest);
    }

    @ApiOperation(value = "Metodo responsavel por retornar todas as entregas  com atraso")
    @GetMapping("/atrasos/filtro")
    public DadosGraficoResponse listaEntregasComAtraso(FiltroRelatorioRequest filtroRelatorioRequest){
        return entregaService.dadosGraficoEntregaAtraso(filtroRelatorioRequest);
    }


}
