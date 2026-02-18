package br.com.PedidosAPI.ordering_system.service;

import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoResponse;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoUpdateDTO;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoUpdateEstoque;
import br.com.PedidosAPI.ordering_system.exception.NotFoundProdutoException;
import br.com.PedidosAPI.ordering_system.mapper.ProdutoMapper;
import br.com.PedidosAPI.ordering_system.model.Produto;
import br.com.PedidosAPI.ordering_system.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<ProdutoResponse> getall(Pageable pageable){
        Page<Produto> produtos = repository.findAll(pageable);

        return produtos.map(mapper::toResponse);
    }

    public ProdutoResponse listById(Long id){
        Produto produto = repository.findById(id).orElseThrow(
                () -> new NotFoundProdutoException(id)
        );

        return mapper.toResponse(produto);

    }

    public ProdutoResponse createProduto(ProdutoCreateRequest dto){
        Produto novoProduto = mapper.toEntity(dto);
        Produto saveNovoProduto = repository.save(novoProduto);


        return mapper.toResponse(saveNovoProduto);

    }

    public void delete(Long id){
        Produto produto = repository.findById(id).orElseThrow(
                () -> new NotFoundProdutoException(id)
        );

        repository.delete(produto);
    }

    @Transactional
    public ProdutoResponse updateEstoque(Long id, ProdutoUpdateEstoque dtoUpd){

        Produto produto = repository.findById(id).orElseThrow(
                () -> new NotFoundProdutoException(id)
        );

        produto.setEstoque(produto.getEstoque() + dtoUpd.getEstoque());

        Produto produtoAtualizado = repository.save(produto);

        return mapper.toResponse(produtoAtualizado);
    }

    @Transactional
    public ProdutoResponse updatePartialProduto(Long id, ProdutoUpdateDTO dtoUp){

        Produto produto = repository.findById(id).orElseThrow(
                () -> new NotFoundProdutoException(id)
        );

        if(dtoUp.getNome() != null){
            produto.setNome(dtoUp.getNome());
        }
        if(dtoUp.getPreco() != null){
            produto.setPreco(dtoUp.getPreco());
        }
        if (dtoUp.getEstoque() != null){
            produto.setEstoque(dtoUp.getEstoque());

        }
        if(dtoUp.getCategoria() != null){
            produto.setCategoria(dtoUp.getCategoria());
        }

        Produto theUpdateProduto = repository.save(produto);

        return mapper.toResponse(theUpdateProduto);
    }
}
