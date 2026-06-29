package com.gustavo.nagai.baozistore.service;

import com.gustavo.nagai.baozistore.dto.ProdutoCreateDTO;
import com.gustavo.nagai.baozistore.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {
    List<ProdutoResponseDTO> getAllProduto();

    ProdutoResponseDTO createNewProduto(ProdutoCreateDTO produtoRequest);

    ProdutoResponseDTO getProdutoById(Long produtoId);

    void deleteProdutoById(Long produtoId);
}
