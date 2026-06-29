package com.gustavo.nagai.baozistore.dto;

import com.gustavo.nagai.baozistore.model.Cliente;
import com.gustavo.nagai.baozistore.model.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um Cliente")
public class PedidoResponseDTO {

    @Schema(
            description = "Identificador único do Pedido",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Identificador único do Cliente",
            example = "1"
    )
    private Long clienteId;

    @Schema(
            description = "Identificador único do Produto",
            example = "1"
    )
    private Long produtoId;

    @Schema(
            description = "Quantidade do produto no pedido",
            example = "3"
    )
    private Integer quantidade;

}
