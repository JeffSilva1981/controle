package com.jsoftwar.controle.de.pedidos.repositories;

import com.jsoftwar.controle.de.pedidos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
