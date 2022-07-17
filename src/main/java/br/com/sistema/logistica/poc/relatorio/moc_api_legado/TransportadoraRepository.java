package br.com.sistema.logistica.poc.relatorio.moc_api_legado;

import br.com.sistema.logistica.poc.mock_legado.TransportadoraLegado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<TransportadoraLegado, Long> {
}
