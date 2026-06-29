package com.gustavo.nagai.baozistore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para criação de um Pedido")
public class PedidoCreateDTO {

    @Schema(
            description = "Identificador único do Cliente",
            example = "1"
    )
    @NotNull(message = "O cliente é obrigatório.")
    private Long clienteId;

    @Schema(
            description = "Identificador único do Produto",
            example = "1"
    )
    @NotNull(message = "O Produto é obrigatório.")
    private Long produtoId;

    @Schema(
            description = "Quantidade do produto no pedido",
            example = "3"
    )
    @NotNull(message = "A quantidade é obrigatória.")
    @Min(value = 1, message = "A quantidade deve ser maior que zero.")
    private Integer quantidade;

}
