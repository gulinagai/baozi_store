package com.gustavo.nagai.baozistore.controller;


import com.gustavo.nagai.baozistore.dto.ClienteCreateDTO;
import com.gustavo.nagai.baozistore.dto.ClienteResponseDTO;
import com.gustavo.nagai.baozistore.service.ClienteService;
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
        name = "Clientes",
        description = "Operações relacionadas aos clientes"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Operation(summary = "Consultar todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllCliente() {
        return ResponseEntity.ok(clienteService.getAllCliente());
    }

    @Operation(summary = "Consultar um cliente")
    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.ok(clienteService.getClienteById(clienteId));
    }

    @Operation(summary = "Cadastrar um cliente")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> createNewCliente(@Valid @RequestBody ClienteCreateDTO clienteRequest) {

        ClienteResponseDTO novoCliente = clienteService.createNewCliente(clienteRequest);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/clientes/" + novoCliente.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(novoCliente);
    }

    @Operation(summary = "Excluir um cliente")
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable("clienteId") Long clienteId) {
        clienteService.deleteClienteById(clienteId);

        return ResponseEntity.noContent().build();
    }

}
