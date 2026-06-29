package com.gustavo.nagai.baozistore.service;

import com.gustavo.nagai.baozistore.dto.ClienteCreateDTO;
import com.gustavo.nagai.baozistore.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteResponseDTO> getAllCliente();

    ClienteResponseDTO getClienteById(Long clienteId);

    ClienteResponseDTO createNewCliente(ClienteCreateDTO clienteRequest);

    void deleteClienteById(Long clienteId);
}
