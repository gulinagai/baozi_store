package com.gustavo.nagai.baozistore.dto;

import com.gustavo.nagai.baozistore.model.Cliente;
import com.gustavo.nagai.baozistore.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private Long produtoId;
    private Integer quantidade;

}
