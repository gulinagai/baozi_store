package com.gustavo.nagai.baozistore.repository;

import com.gustavo.nagai.baozistore.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
