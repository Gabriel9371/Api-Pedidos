package br.com.PedidosAPI.ordering_system.service;


import br.com.PedidosAPI.ordering_system.dto.clienteDTO.ClienteCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.clienteDTO.ClienteResponse;
import br.com.PedidosAPI.ordering_system.exception.NotFoundUserId;
import br.com.PedidosAPI.ordering_system.mapper.ClienteMapper;
import br.com.PedidosAPI.ordering_system.model.Cliente;
import br.com.PedidosAPI.ordering_system.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public ClienteService(ClienteMapper mapper, ClienteRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<ClienteResponse> getall(){
        List<Cliente> todosOsClientes = repository.findAll();
        List<ClienteResponse> listaDeClientes = mapper.toResponseList(todosOsClientes);

        return listaDeClientes;
    }

    public ClienteResponse listById(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new NotFoundUserId(id)
        );

        return mapper.toResponse(cliente);
    }

    public ClienteResponse criarCliente(ClienteCreateRequest dto){
        Cliente cliente = mapper.toEntity(dto);
        Cliente savecliente = repository.save(cliente);

        return mapper.toResponse(savecliente);
    }

    public void deletar(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new NotFoundUserId(id)
        );

        repository.delete(cliente);
    }

}
