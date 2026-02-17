package br.com.PedidosAPI.ordering_system.exception;

public class NotFoundProdutoException extends RuntimeException {
    public NotFoundProdutoException(Long id) {
        super("Produto com " + id + " não encontrado");
    }
}
