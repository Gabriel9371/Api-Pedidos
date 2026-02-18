package br.com.PedidosAPI.ordering_system.controller;


import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoResponse;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoUpdateDTO;
import br.com.PedidosAPI.ordering_system.dto.produtoDTO.ProdutoUpdateEstoque;
import br.com.PedidosAPI.ordering_system.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listAllNotes(Pageable pageable){
        Page<ProdutoResponse> allNotesP = service.getall(pageable);

        return ResponseEntity.ok(allNotesP);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> listById(@PathVariable Long id){
        ProdutoResponse produto = service.listById(id);

        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody @Valid ProdutoCreateRequest dto){
        ProdutoResponse produto = service.createProduto(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> updateEstoque(@PathVariable Long id, @RequestBody @Valid ProdutoUpdateEstoque dados){
        ProdutoResponse produto = service.updateEstoque(id, dados);

        return ResponseEntity.ok(produto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponse> patchProduto(@PathVariable Long id, @RequestBody @Valid ProdutoUpdateDTO dados){
        ProdutoResponse produto = service.updatePartialProduto(id, dados);

        return ResponseEntity.ok(produto);
    }

}
