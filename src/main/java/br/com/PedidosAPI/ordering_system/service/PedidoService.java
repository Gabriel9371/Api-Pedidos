package br.com.PedidosAPI.ordering_system.service;

import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoResponse;
import br.com.PedidosAPI.ordering_system.mapper.PedidoMapper;
import br.com.PedidosAPI.ordering_system.model.Pedido;
import br.com.PedidosAPI.ordering_system.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoMapper mapper;
    private final PedidoRepository repository;

    public PedidoService(PedidoMapper mapper, PedidoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<PedidoResponse> allPedidos(){
        List<Pedido> todosPedidos
    }
}
