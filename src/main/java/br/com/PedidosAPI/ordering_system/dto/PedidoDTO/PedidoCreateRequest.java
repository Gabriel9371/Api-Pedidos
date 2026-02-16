package br.com.PedidosAPI.ordering_system.dto.PedidoDTO;

import br.com.PedidosAPI.ordering_system.enums.Status;
import jakarta.validation.constraints.NotNull;

public class PedidoCreateRequest {

    @NotNull
    private Status status;
    @NotNull
    private Long clienteId;
    @NotNull
    private Double total;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
