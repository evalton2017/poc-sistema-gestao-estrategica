package br.com.sistema.logistica.poc.cliente;

import br.com.sistema.logistica.poc.mock_legado.ClienteLegado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteLegado, Long> {
}
