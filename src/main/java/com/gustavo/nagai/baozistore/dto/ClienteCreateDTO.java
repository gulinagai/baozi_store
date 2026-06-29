package com.gustavo.nagai.baozistore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCreateDTO {

    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

}
