package com.gustavo.nagai.baozistore.controller;


import com.gustavo.nagai.baozistore.dto.PedidoCreateDTO;
import com.gustavo.nagai.baozistore.dto.PedidoResponseDTO;
import com.gustavo.nagai.baozistore.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Pedidos",
        description = "Operações relacionadas aos pedidos"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Operation(summary = "Consultar todos os pedidos")
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> getAllPedido() {
        return ResponseEntity.ok(pedidoService.getAllPedido());
    }

    @Operation(summary = "Consultar um pedido")
    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponseDTO> getPedidoById(@PathVariable("pedidoId") Long pedidoId) {
        return ResponseEntity.ok(pedidoService.getPedidoById(pedidoId));
    }

    @Operation(summary = "Cadastrar um pedido")
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> createNewPedido(@Valid @RequestBody PedidoCreateDTO pedidoRequest) {

        PedidoResponseDTO novoPedido = pedidoService.createNewPedido(pedidoRequest);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/pedidos/" + novoPedido.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(novoPedido);
    }

    @Operation(summary = "Excluir um pedido")
    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Void> deletePedidoById(@PathVariable("pedidoId") Long pedidoId) {
        pedidoService.deletePedidoById(pedidoId);

        return ResponseEntity.noContent().build();
    }


}
