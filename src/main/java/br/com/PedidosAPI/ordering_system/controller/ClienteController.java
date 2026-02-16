package br.com.PedidosAPI.ordering_system.controller;


import br.com.PedidosAPI.ordering_system.dto.clienteDTO.ClienteCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.clienteDTO.ClienteResponse;
import br.com.PedidosAPI.ordering_system.model.Cliente;
import br.com.PedidosAPI.ordering_system.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> litarTodosOsClientes(){
        List<ClienteResponse> all = service.getall();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> listarClienteById(@PathVariable Long id){
        ClienteResponse cliente = service.listById(id);

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(@RequestBody @Valid ClienteCreateRequest dto){
        ClienteResponse novoCliente = service.criarCliente(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponse> deletarCliente(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
