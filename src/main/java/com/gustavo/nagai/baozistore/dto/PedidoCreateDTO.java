package com.gustavo.nagai.baozistore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoCreateDTO {


    private Long clienteId;

    private Long produtoId;

    private Integer quantidade;

}
