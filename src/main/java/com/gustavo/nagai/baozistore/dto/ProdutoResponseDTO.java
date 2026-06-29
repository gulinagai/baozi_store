package com.gustavo.nagai.baozistore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um Produto")
public class ProdutoResponseDTO {

    @Schema(
            description = "Identificador único do Produto",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Nome do Produto",
            example = "Baozi Exemplo"
    )
    private String nome;

    @Schema(
            description = "Preço unitário do produto",
            example = "9.99"
    )
    private BigDecimal preco;

    @Schema(
            description = "Indicativo se possui estoque ou não",
            example = "true"
    )
    private Boolean estoque;

}
