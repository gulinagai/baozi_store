package com.gustavo.nagai.baozistore.controller;

import com.gustavo.nagai.baozistore.dto.ProdutoCreateDTO;
import com.gustavo.nagai.baozistore.dto.ProdutoResponseDTO;
import com.gustavo.nagai.baozistore.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Produtos",
        description = "Operações relacionadas aos produtos"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Operation(summary = "Consultar todos os produtos")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getAllProduto() {
        return ResponseEntity.ok(produtoService.getAllProduto());
    }

    @Operation(summary = "Consultar um produto")
    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable("produtoId") Long produtoId) {
        return ResponseEntity.ok(produtoService.getProdutoById(produtoId));
    }

    @Operation(summary = "Cadastrar um produto")
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createNewProduto(@RequestBody ProdutoCreateDTO produtoRequest) {

        ProdutoResponseDTO novoProduto = produtoService.createNewProduto(produtoRequest);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/produtos/" + novoProduto.getId().toString());

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(novoProduto);
    }

    @Operation(summary = "Excluir um produto")
    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable("produtoId") Long produtoId) {
        produtoService.deleteProdutoById(produtoId);

        return ResponseEntity.noContent().build();
    }

}
