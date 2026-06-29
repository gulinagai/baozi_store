package com.gustavo.nagai.baozistore.controller;

import com.gustavo.nagai.baozistore.dto.ProdutoCreateDTO;
import com.gustavo.nagai.baozistore.dto.ProdutoResponseDTO;
import com.gustavo.nagai.baozistore.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getAllProduto() {
        return ResponseEntity.ok(produtoService.getAllProduto());
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable("produtoId") Long produtoId) {
        return ResponseEntity.ok(produtoService.getProdutoById(produtoId));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createNewProduto(@RequestBody ProdutoCreateDTO produtoRequest) {

        ProdutoResponseDTO novoProduto = produtoService.createNewProduto(produtoRequest);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/produtos/" + novoProduto.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(novoProduto);
    }


    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable("produtoId") Long produtoId) {
        produtoService.deleteProdutoById(produtoId);

        return ResponseEntity.noContent().build();
    }

}
