package com.gustavo.nagai.baozistore.mapper;

import com.gustavo.nagai.baozistore.dto.ProdutoCreateDTO;
import com.gustavo.nagai.baozistore.dto.ProdutoResponseDTO;
import com.gustavo.nagai.baozistore.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // DTO para Entity (Create)
    Produto toEntity(ProdutoCreateDTO dto);

    // Entity para DTO (Response)
    ProdutoResponseDTO toDTO(Produto produto);
}
