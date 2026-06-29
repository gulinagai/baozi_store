package com.gustavo.nagai.baozistore.controller;


import com.gustavo.nagai.baozistore.dto.PedidoCreateDTO;
import com.gustavo.nagai.baozistore.dto.PedidoResponseDTO;
import com.gustavo.nagai.baozistore.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> getAllPedido() {
        return ResponseEntity.ok(pedidoService.getAllPedido());
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponseDTO> getPedidoById(@PathVariable("pedidoId") Long pedidoId) {
        return ResponseEntity.ok(pedidoService.getPedidoById(pedidoId));
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> createNewPedido(@RequestBody PedidoCreateDTO pedidoRequest) {

        PedidoResponseDTO novoPedido = pedidoService.createNewPedido(pedidoRequest);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/pedidos/" + novoPedido.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(novoPedido);
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Void> deletePedidoById(@PathVariable("pedidoId") Long pedidoId) {
        pedidoService.deletePedidoById(pedidoId);

        return ResponseEntity.noContent().build();
    }


}
