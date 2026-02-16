package br.com.PedidosAPI.ordering_system.repository;

import br.com.PedidosAPI.ordering_system.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
