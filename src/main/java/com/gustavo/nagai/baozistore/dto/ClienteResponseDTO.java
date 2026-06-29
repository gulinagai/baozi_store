package com.gustavo.nagai.baozistore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um Cliente")
public class ClienteResponseDTO {

    @Schema(
            description = "Identificador único do Cliente",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Nome do Cliente",
            example = "NomeSobrenome1234567"
    )
    private String nome;

    @Schema(
            description = "Data em que o Cliente foi cadastrado",
            example = "2026-06-29"
    )
    private LocalDate clienteDesde;

}
