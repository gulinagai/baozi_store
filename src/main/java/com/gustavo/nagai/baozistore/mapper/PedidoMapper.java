package com.gustavo.nagai.baozistore.mapper;

import com.gustavo.nagai.baozistore.dto.PedidoCreateDTO;
import com.gustavo.nagai.baozistore.dto.PedidoResponseDTO;
import com.gustavo.nagai.baozistore.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    // DTO para Entity (Create)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "produto", ignore = true)
    Pedido toEntity(PedidoCreateDTO dto);

    // Entity para DTO (Response)
    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "produto.id", target = "produtoId")
    PedidoResponseDTO toDTO(Pedido pedido);

}
