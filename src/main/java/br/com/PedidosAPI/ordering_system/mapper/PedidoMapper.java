package br.com.PedidosAPI.ordering_system.mapper;


import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoResponse;
import br.com.PedidosAPI.ordering_system.model.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapper {
    public Pedido toEntity(PedidoCreateRequest dto){
        Pedido pedido = new Pedido();


        pedido.setTotal(dto.getTotal());
        pedido.setStatus(dto.getStatus());


        return pedido;
    }

    public PedidoResponse toResponse(Pedido dados){
        PedidoResponse response = new PedidoResponse();

        response.setId(dados.getId());
        response.setStatus(dados.getStatus());
        response.setClienteId(dados.getCliente().getId());
        response.setTotal(dados.getTotal());

        return response;
    }

    public List<PedidoResponse> toResponseList(List<Pedido> pedidos){
        return pedidos.stream().map(this::toResponse).toList();
    }
}
