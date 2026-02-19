package br.com.PedidosAPI.ordering_system.mapper;

import br.com.PedidosAPI.ordering_system.dto.itemDTO.ItemCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.itemDTO.ItemResponse;
import br.com.PedidosAPI.ordering_system.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {

    public Item toEntity(ItemCreateRequest dto){
        Item item = new Item();

        item.setPreco(dto.getPreco());
        item.setQuantidade(dto.getQuantidade());

        return item;
    }

    public ItemResponse toResponse(Item dados){
        ItemResponse response = new ItemResponse();

        response.setId(dados.getId());
        response.setPedidoId(dados.getPedido().getId());
        response.setProdutoId(dados.getProduto().getId());
        response.setPreco(dados.getPreco());
        response.setQuantidade(dados.getQuantidade());

        return response;
    }

    public List<ItemResponse> toResponseList(List<Item> items){
        return items.stream().map(this::toResponse).toList();
    }
}
