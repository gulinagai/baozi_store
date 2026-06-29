package com.gustavo.nagai.baozistore.service;

import com.gustavo.nagai.baozistore.dto.PedidoCreateDTO;
import com.gustavo.nagai.baozistore.dto.PedidoResponseDTO;

import java.util.List;

public interface PedidoService {

    List<PedidoResponseDTO> getAllPedido();

    PedidoResponseDTO getPedidoById(Long pedidoId);

    PedidoResponseDTO createNewPedido(PedidoCreateDTO pedidoRequest);

    void deletePedidoById(Long pedidoId);

}
