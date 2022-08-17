package br.com.sistema.logistica.poc.entrega.repository;

import br.com.sistema.logistica.poc.entrega.dto.FiltroRelatorioRequest;
import br.com.sistema.logistica.poc.mock_legado.EntregaLegado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

public class EntregaRepositoryImpl implements CustomRepository{


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<EntregaLegado> findByEntrega(FiltroRelatorioRequest filtro) {
        StringBuilder query = montaQueryBuscaEntregas();
        adicionarFiltros(filtro,query);
        return entityManager.createQuery(query.toString()).getResultList();
    }

    @Override
    public List<EntregaLegado> findByEntregaByDataPedido(String inicio, String fim) {
        StringBuilder query = montaQueryBuscaEntregas();
        query.append("AND p.dataPedido BETWEEN ").append("'"+inicio+"' AND "+"'"+fim+"'");
        return entityManager.createQuery(query.toString()).getResultList();
    }

    private StringBuilder montaQueryBuscaEntregas() {
        StringBuilder query = new StringBuilder();
        query.append("FROM EntregaLegado e ");
        query.append(" left join fetch e.transportadoraLegado t ");
        query.append(" left join fetch e.pedidoLegado p ");
        query.append(" where 1 = 1 ");
        return query;
    }

    private void adicionarFiltros(final FiltroRelatorioRequest filtroModeloDTO, final StringBuilder query) {
        if(Objects.nonNull(filtroModeloDTO.getIdTransportadora())){
            query.append(" and t.idTransportadora =  "+filtroModeloDTO.getIdTransportadora());
        }

        if(Objects.nonNull(filtroModeloDTO.getNumeroPedido())){
            query.append(" and p.numeroPedido = "+filtroModeloDTO.getNumeroPedido());
        }

        if(Objects.nonNull(filtroModeloDTO.getSituacao())){
            query.append(" and e.situacaoEntrega.id = "+filtroModeloDTO.getSituacao());
        }

        if(Objects.nonNull(filtroModeloDTO.getDataInicio()) && Objects.nonNull(filtroModeloDTO.getDataFim())){
            query.append("AND p.dataPedido BETWEEN ").append("'"+filtroModeloDTO.getDataInicio()+"' AND "+"'"+filtroModeloDTO.getDataFim()+"'");
        }

        query.append(" order by e.idEntrega ");
    }
}
