package br.com.PedidosAPI.ordering_system.mapper;


import br.com.PedidosAPI.ordering_system.dto.clienteDTO.ClienteCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.clienteDTO.ClienteResponse;
import br.com.PedidosAPI.ordering_system.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteCreateRequest dto){
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        return cliente;
    }

    public ClienteResponse toResponse(Cliente dados){
        ClienteResponse response = new ClienteResponse();

        response.setId(dados.getId());
        response.setNome(dados.getNome());
        response.setEmail(dados.getEmail());

        return response;
    }


    public List<ClienteResponse> toResponseList(List<Cliente> clientes){
        return clientes.stream().map(n -> toResponse(n)).toList();
    }
}
