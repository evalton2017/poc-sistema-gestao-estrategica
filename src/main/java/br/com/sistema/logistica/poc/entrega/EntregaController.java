package br.com.sistema.logistica.poc.entrega;

import br.com.sistema.logistica.poc.entrega.dto.DadosGraficoResponse;
import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    EntregaService entregaService;

    @ApiOperation(value = "Metodo responsavel por retornar todas as entregas do ano corrente")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DadosGraficoResponse> listarEntregas(){
        return  ResponseEntity.ok(entregaService.dadosGraficoEntrega());
    }

    @ApiOperation(value = "Metodo responsavel por retornar todas as entregas  do mês corrente(default) ou filtro")
    @GetMapping("/filtro")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DadosGraficoResponse> listarEntregasComFiltro(FiltroRelatorioRequest filtroRelatorioRequest){
         return ResponseEntity.ok(entregaService.dadosGraficoEntregaFiltro(filtroRelatorioRequest));
    }

    @ApiOperation(value = "Metodo responsavel por retornar todas as entregas  com atraso")
    @GetMapping("/atrasos/filtro")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DadosGraficoResponse> listaEntregasComAtraso(FiltroRelatorioRequest filtroRelatorioRequest){
        return ResponseEntity.ok(entregaService.dadosGraficoEntregaAtraso(filtroRelatorioRequest));
    }


}
