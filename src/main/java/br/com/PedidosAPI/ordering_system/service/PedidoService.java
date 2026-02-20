package br.com.PedidosAPI.ordering_system.service;

import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoResponse;
import br.com.PedidosAPI.ordering_system.dto.itemDTO.ItemCreateRequest;
import br.com.PedidosAPI.ordering_system.enums.Status;
import br.com.PedidosAPI.ordering_system.exception.NotFoundUserId;
import br.com.PedidosAPI.ordering_system.mapper.PedidoMapper;
import br.com.PedidosAPI.ordering_system.model.Cliente;
import br.com.PedidosAPI.ordering_system.model.Item;
import br.com.PedidosAPI.ordering_system.model.Pedido;
import br.com.PedidosAPI.ordering_system.model.Produto;
import br.com.PedidosAPI.ordering_system.repository.ClienteRepository;
import br.com.PedidosAPI.ordering_system.repository.PedidoRepository;
import br.com.PedidosAPI.ordering_system.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoMapper mapper;
    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoMapper mapper, PedidoRepository repository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public PedidoResponse savePedido(PedidoCreateRequest dto){
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(
                () -> new NotFoundUserId(dto.getClienteId())
        );

        Pedido pedido = mapper.toEntity(dto);
        pedido.setCliente(cliente);

        if(dto.getStatus() == null){
            dto.setStatus(Status.PREPARANDO_PEDIDO);
        }

        pedido.setStatus(dto.getStatus());


        double valorTotal = 0.0;


        //precisei de ajuda pra fazer isso...
        for(ItemCreateRequest itemDto: dto.getItems()){
            Produto produto = produtoRepository.findById(itemDto.getProdutoId()).orElseThrow();

            Item item = new Item();
            item.setQuantidade(itemDto.getQuantidade());
            item.setPreco(produto.getPreco());
            item.setProduto(produto);
            item.setPedido(pedido);



            valorTotal += item.getPreco() * item.getQuantidade();

            pedido.getItens().add(item);

        }

        pedido.setTotal(Math.round(valorTotal * 100.0) / 100.0);

        Pedido pedidoSave = repository.save(pedido);

        return mapper.toResponse(pedidoSave);

    }

    public List<PedidoResponse> allPedidos(){
        List<Pedido> pedidos = repository.findAll();



        return mapper.toResponseList(pedidos);
    }
}
