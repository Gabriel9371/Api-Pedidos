package br.com.PedidosAPI.ordering_system.repository;

import br.com.PedidosAPI.ordering_system.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
