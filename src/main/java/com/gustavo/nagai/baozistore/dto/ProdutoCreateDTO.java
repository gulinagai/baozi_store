package com.gustavo.nagai.baozistore.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoCreateDTO {

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    @Digits(integer = 10, fraction = 2,
            message = "Preço deve possuir até 10 dígitos inteiros e 2 decimais")
    private BigDecimal preco;

    @NotNull(message = "Estoque é obrigatório")
    private Boolean estoque;

}
