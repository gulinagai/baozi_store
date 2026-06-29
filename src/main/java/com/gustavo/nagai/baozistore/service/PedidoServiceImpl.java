package com.gustavo.nagai.baozistore.service;

import com.gustavo.nagai.baozistore.dto.PedidoCreateDTO;
import com.gustavo.nagai.baozistore.dto.PedidoResponseDTO;
import com.gustavo.nagai.baozistore.exception.RecursoNaoEncontradoException;
import com.gustavo.nagai.baozistore.mapper.PedidoMapper;
import com.gustavo.nagai.baozistore.model.Cliente;
import com.gustavo.nagai.baozistore.model.Pedido;
import com.gustavo.nagai.baozistore.model.Produto;
import com.gustavo.nagai.baozistore.repository.ClienteRepository;
import com.gustavo.nagai.baozistore.repository.PedidoRepository;
import com.gustavo.nagai.baozistore.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> getAllPedido() {
        return pedidoRepository.findAll().stream().map(pedidoMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public PedidoResponseDTO getPedidoById(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(()->
                        new RecursoNaoEncontradoException(
                                "Pedido com id " + pedidoId + " não encontrado."
                        ));
        return pedidoMapper.toDTO(pedido);
    }

    public PedidoResponseDTO createNewPedido(PedidoCreateDTO pedidoRequest) {

        Pedido pedido = pedidoMapper.toEntity(pedidoRequest);

        if(pedidoRequest.getProdutoId() != null) {
            Produto produto = produtoRepository.findById(pedidoRequest.getProdutoId())
                    .orElseThrow(()->
                            new RecursoNaoEncontradoException(
                                    "Produto com id " + pedidoRequest.getProdutoId() + " não encontrado"
                            ));
            pedido.setProduto(produto);
        }

        if(pedidoRequest.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(pedidoRequest.getClienteId())
                    .orElseThrow(()->
                            new RecursoNaoEncontradoException(
                                    "Cliente com id " + pedidoRequest.getClienteId() + " não encontrado"
                            ));
            pedido.setCliente(cliente);
        }

        return pedidoMapper.toDTO(pedidoRepository.save(pedido));
    }

    public void deletePedidoById(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(()->
                        new RecursoNaoEncontradoException(
                                "Pedido com id " + pedidoId + " não encontrado"
                        ));
        pedidoRepository.delete(pedido);
    }

}
