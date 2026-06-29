package com.gustavo.nagai.baozistore.service;

import com.gustavo.nagai.baozistore.dto.ProdutoCreateDTO;
import com.gustavo.nagai.baozistore.dto.ProdutoResponseDTO;
import com.gustavo.nagai.baozistore.exception.RecursoNaoEncontradoException;
import com.gustavo.nagai.baozistore.mapper.ProdutoMapper;
import com.gustavo.nagai.baozistore.model.Produto;
import com.gustavo.nagai.baozistore.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> getAllProduto() {
        return produtoRepository.findAll().stream().map(produtoMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoResponseDTO getProdutoById(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(()->
                        new RecursoNaoEncontradoException(
                           "Produto com id " + produtoId + " não encontrado."
                        ));
        return produtoMapper.toDTO(produto);
    }

    @Override
    public ProdutoResponseDTO createNewProduto(ProdutoCreateDTO produtoRequest) {

        Produto produto = produtoMapper.toEntity(produtoRequest);

        return produtoMapper.toDTO(produtoRepository.save(produto));
    }

    @Override
    public void deleteProdutoById(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(()->
                        new RecursoNaoEncontradoException(
                                "Produto com id " + produtoId + " não encontrado"
                        ));
        produtoRepository.delete(produto);
    }
}
