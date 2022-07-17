package br.com.sistema.logistica.poc.relatorio.moc_api_legado;

import br.com.sistema.logistica.poc.mock_legado.SituacaoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoEntregaRepository extends JpaRepository<SituacaoEntrega, Long> {
}
