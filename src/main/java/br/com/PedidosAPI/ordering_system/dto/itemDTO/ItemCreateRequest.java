package br.com.PedidosAPI.ordering_system.dto.itemDTO;

import jakarta.validation.constraints.NotNull;

public class ItemCreateRequest {
    @NotNull
    private Integer quantidade;
    @NotNull
    private Double preco;
    @NotNull
    private Long produtoId;
    @NotNull
    private Long pedidoId;

    public Integer getQuantidade() {       return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}
