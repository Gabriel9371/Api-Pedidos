package br.com.PedidosAPI.ordering_system.dto.produtoDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProdutoUpdateEstoque {

    @NotNull
    @Min(1)
    private Integer estoque;

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
