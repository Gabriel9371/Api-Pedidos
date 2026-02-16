package br.com.PedidosAPI.ordering_system.exception;

public class NotFoundUserId extends RuntimeException {
    public NotFoundUserId(Long id) {
        super("Usuario com " + id + " não encontrado");
    }
}
