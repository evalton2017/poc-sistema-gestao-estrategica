package br.com.sistema.logistica.poc.entrega;

import br.com.sistema.logistica.poc.entrega.dto.legado.TransportadoraLegadoResponse;
import br.com.sistema.logistica.poc.relatorio.moc_api_legado.ProdutoRepository;
import br.com.sistema.logistica.poc.relatorio.moc_api_legado.SituacaoEntregaRepository;
import br.com.sistema.logistica.poc.relatorio.moc_api_legado.TransportadoraRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LegadoController {

    @Autowired
    TransportadoraRepository transportadoraRepository;

    @Autowired
    SituacaoEntregaRepository situacaoEntregaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Metodo que simula integração com Legado para busca de transportadoras.")
    @GetMapping("transportadoras")
    public List<TransportadoraLegadoResponse> listaTransportadoraLegado(){
        return transportadoraRepository.findAll()
                .stream()
                .map(TransportadoraLegadoResponse::of)
                .collect(Collectors.toList());
    }


}
