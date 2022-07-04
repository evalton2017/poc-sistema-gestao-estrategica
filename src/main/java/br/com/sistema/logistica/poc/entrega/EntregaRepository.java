package br.com.sistema.logistica.poc.entrega;

import br.com.sistema.logistica.poc.entrega.dto.repository.CustomRepository;
import br.com.sistema.logistica.poc.moc_legado.EntregaLegado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<EntregaLegado, Long>, CustomRepository {



}
