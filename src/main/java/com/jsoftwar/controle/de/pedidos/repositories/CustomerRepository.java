package com.jsoftwar.controle.de.pedidos.repositories;

import com.jsoftwar.controle.de.pedidos.entities.Customer;
import com.jsoftwar.controle.de.pedidos.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCellPhone(String cellPhone);

    @Query(nativeQuery = true, value = """
    SELECT tb_customers.cell_phone AS username, tb_customers.password, tb_role.id AS roleId, tb_role.authority
    FROM tb_customers
    INNER JOIN tb_customers_role ON tb_customers.id = tb_customers_role.customer_id
    INNER JOIN tb_role ON tb_role.id = tb_customers_role.role_id
    WHERE tb_customers.cell_phone = :cell_phone
    """)
    List<UserDetailsProjection> searchUserAndRolesByCellPhone(@Param("cell_phone") String cellPhone);
}
