package br.com.PedidosAPI.ordering_system.repository;

import br.com.PedidosAPI.ordering_system.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
