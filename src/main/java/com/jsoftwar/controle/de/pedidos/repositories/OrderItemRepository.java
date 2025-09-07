package com.jsoftwar.controle.de.pedidos.repositories;

import com.jsoftwar.controle.de.pedidos.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
