package com.gustavo.nagai.baozistore.repository;

import com.gustavo.nagai.baozistore.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
