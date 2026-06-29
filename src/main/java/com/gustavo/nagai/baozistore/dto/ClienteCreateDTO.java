package com.gustavo.nagai.baozistore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para criação de um Cliente")
public class ClienteCreateDTO {

    @Schema(
            description = "Nome do Cliente",
            example = "NomeSobrenome1234567"
    )
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

}
