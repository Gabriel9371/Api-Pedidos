package br.com.PedidosAPI.ordering_system.dto.PedidoDTO;

import br.com.PedidosAPI.ordering_system.dto.itemDTO.ItemCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.itemDTO.ItemResponse;
import br.com.PedidosAPI.ordering_system.enums.Status;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidoCreateRequest {


    private Status status;


    @NotNull
    private Long clienteId;


    private List<ItemCreateRequest> items;



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

    public List<ItemCreateRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemCreateRequest> items) {
        this.items = items;
    }
}
