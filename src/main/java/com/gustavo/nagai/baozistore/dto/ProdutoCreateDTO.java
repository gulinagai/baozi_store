package com.gustavo.nagai.baozistore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para criação de um Produto")
public class ProdutoCreateDTO {

    @Schema(
            description = "Nome do Produto",
            example = "Baozi Exemplo"
    )
    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @Schema(
            description = "Preço unitário do produto",
            example = "9.99"
    )
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    @Digits(integer = 10, fraction = 2,
            message = "Preço deve possuir até 10 dígitos inteiros e 2 decimais")
    private BigDecimal preco;

    @Schema(
            description = "Indicativo se possui estoque ou não",
            example = "true"
    )
    @NotNull(message = "Estoque é obrigatório")
    private Boolean estoque;

}
