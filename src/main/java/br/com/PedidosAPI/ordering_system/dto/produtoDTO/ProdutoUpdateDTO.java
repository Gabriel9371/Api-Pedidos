package br.com.PedidosAPI.ordering_system.dto.produtoDTO;

import br.com.PedidosAPI.ordering_system.enums.Categoria;
import jakarta.validation.constraints.Min;

public class ProdutoUpdateDTO {
    private String nome;
    private Double preco;

    @Min(0)
    private Integer estoque;

    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
