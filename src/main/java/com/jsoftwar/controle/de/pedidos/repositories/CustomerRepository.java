package com.jsoftwar.controle.de.pedidos.repositories;

import com.jsoftwar.controle.de.pedidos.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
