package br.com.sistema.logistica.poc.entrega.repository;

import br.com.sistema.logistica.poc.mock_legado.EntregaLegado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<EntregaLegado, Long>, CustomRepository {


}
