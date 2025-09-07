package com.jsoftwar.controle.de.pedidos.repositories;

import com.jsoftwar.controle.de.pedidos.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
