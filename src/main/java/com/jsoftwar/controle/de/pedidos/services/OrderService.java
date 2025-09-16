package com.jsoftwar.controle.de.pedidos.services;

import com.jsoftwar.controle.de.pedidos.DTO.OrderDTO;
import com.jsoftwar.controle.de.pedidos.entities.Order;
import com.jsoftwar.controle.de.pedidos.repositories.OrderRepository;
import com.jsoftwar.controle.de.pedidos.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order entity = repository.findById(id).orElseThrow(()-> new com.jsoftwar.controle.de.pedidos.services.exceptions.
                EntityNotFoundException("Entity not Found"));
        return new OrderDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<OrderDTO> findAll(Pageable pageable) {
        Page<Order> entity = repository.findAll(pageable);
        return entity.map(x-> new OrderDTO(x));
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order entity = new Order();
        copyDtoToEntity(dto, entity);
        entity.calculateTotalValue();
        entity = repository.save(entity);
        return new OrderDTO(entity);
    }

    @Transactional
    public OrderDTO update(Long id, OrderDTO dto) {

        try {
            Order entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity.calculateTotalValue();
            entity = repository.save(entity);
            return new OrderDTO(entity);

        }catch (EntityNotFoundException e){
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.
                    EntityNotFoundException("Entity not Found");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.
                    EntityNotFoundException("Entity not Found");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity Violation");
        }
    }

    private void copyDtoToEntity(OrderDTO dto, Order entity) {
        entity.setOrderDate(dto.getDateOfOrder());
        entity.setStatus(dto.getStatus());
        entity.setProofOfPayment(dto.getProofOfPayment());
    }
}
