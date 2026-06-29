package com.gustavo.nagai.baozistore.mapper;

import com.gustavo.nagai.baozistore.dto.ClienteCreateDTO;
import com.gustavo.nagai.baozistore.dto.ClienteResponseDTO;

import com.gustavo.nagai.baozistore.model.Cliente;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    // DTO para Entity (Create)
    Cliente toEntity(ClienteCreateDTO dto);

    // Entity para DTO (Response)
    ClienteResponseDTO toDTO(Cliente cliente);
}
