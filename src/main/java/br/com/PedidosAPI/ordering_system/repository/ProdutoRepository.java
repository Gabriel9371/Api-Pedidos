package br.com.PedidosAPI.ordering_system.repository;

import br.com.PedidosAPI.ordering_system.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
