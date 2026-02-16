package br.com.PedidosAPI.ordering_system.dto.PedidoDTO;

import br.com.PedidosAPI.ordering_system.enums.Status;

import java.time.LocalDate;

public class PedidoResponse {
    private Long id;
    private LocalDate data;
    private Status status;
    private Long clienteId;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

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
