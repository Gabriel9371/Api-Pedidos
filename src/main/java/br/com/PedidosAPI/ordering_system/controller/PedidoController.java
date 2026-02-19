package br.com.PedidosAPI.ordering_system.controller;


import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoCreateRequest;
import br.com.PedidosAPI.ordering_system.dto.PedidoDTO.PedidoResponse;
import br.com.PedidosAPI.ordering_system.model.Pedido;
import br.com.PedidosAPI.ordering_system.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<PedidoResponse>> allPedidos(){
       List<PedidoResponse> pedido = service.allPedidos();

       return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> createPedido(@RequestBody @Valid PedidoCreateRequest pedido){
        PedidoResponse createpedido = service.savePedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(createpedido);
    }
}
