package com.gustavo.nagai.baozistore.controller;


import com.gustavo.nagai.baozistore.dto.ClienteCreateDTO;
import com.gustavo.nagai.baozistore.dto.ClienteResponseDTO;
import com.gustavo.nagai.baozistore.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllCliente() {
        return ResponseEntity.ok(clienteService.getAllCliente());
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.ok(clienteService.getClienteById(clienteId));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> createNewCliente(@RequestBody ClienteCreateDTO clienteRequest) {

        ClienteResponseDTO novoCliente = clienteService.createNewCliente(clienteRequest);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/clientes/" + novoCliente.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(novoCliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable("clienteId") Long clienteId) {
        clienteService.deleteClienteById(clienteId);

        return ResponseEntity.noContent().build();
    }

}
