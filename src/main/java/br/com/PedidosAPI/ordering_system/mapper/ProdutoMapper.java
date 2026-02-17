package br.com.PedidosAPI.ordering_system.mapper;

import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoResponse;
import br.com.PedidosAPI.ordering_system.model.Produto;
import org.springframework.stereotype.Component;


@Component
public class ProdutoMapper {
    public Produto toEntity(ProdutoCreateRequest dto){
        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setCategoria(dto.getCategoria());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());

        return produto;

    }

    public ProdutoResponse toResponse(Produto dados){
        ProdutoResponse response = new ProdutoResponse();

        response.setId(dados.getId());
        response.setNome(dados.getNome());
        response.setCategoria(dados.getCategoria());
        response.setPreco(dados.getPreco());
        response.setEstoque(dados.getEstoque());

        return response;
    }

    //pageable ao invés de 'toResponseList'
}
