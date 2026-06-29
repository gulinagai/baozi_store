package com.gustavo.nagai.baozistore.service;

import com.gustavo.nagai.baozistore.dto.ClienteCreateDTO;
import com.gustavo.nagai.baozistore.dto.ClienteResponseDTO;
import com.gustavo.nagai.baozistore.exception.RecursoNaoEncontradoException;
import com.gustavo.nagai.baozistore.mapper.ClienteMapper;
import com.gustavo.nagai.baozistore.model.Cliente;
import com.gustavo.nagai.baozistore.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> getAllCliente() {
        return clienteRepository.findAll().stream().map(clienteMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponseDTO getClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(()->
                        new RecursoNaoEncontradoException(
                                "Cliente com id " + clienteId + " não encontrado."
                        ));
        return clienteMapper.toDTO(cliente);
    }

    @Override
    public ClienteResponseDTO createNewCliente(ClienteCreateDTO clienteRequest) {

        Cliente cliente = clienteMapper.toEntity(clienteRequest);

        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    @Override
    public void deleteClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(()->
                        new RecursoNaoEncontradoException(
                                "Cliente com id " + clienteId + " não encontrado"
                        ));
        clienteRepository.delete(cliente);
    }

}
