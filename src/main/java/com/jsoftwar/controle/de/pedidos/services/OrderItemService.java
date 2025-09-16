package com.jsoftwar.controle.de.pedidos.services;

import com.jsoftwar.controle.de.pedidos.DTO.OrderItemDTO;
import com.jsoftwar.controle.de.pedidos.entities.Order;
import com.jsoftwar.controle.de.pedidos.entities.OrderItem;
import com.jsoftwar.controle.de.pedidos.entities.Product;
import com.jsoftwar.controle.de.pedidos.repositories.OrderItemRepository;
import com.jsoftwar.controle.de.pedidos.repositories.OrderRepository;
import com.jsoftwar.controle.de.pedidos.repositories.ProductRepository;
import com.jsoftwar.controle.de.pedidos.services.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public OrderItemDTO findById(Long id) {
        OrderItem entity = repository.findById(id).
                orElseThrow(()-> new com.jsoftwar.controle.de.pedidos.services.exceptions.
                        EntityNotFoundException("Entity not found") );
        return new OrderItemDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<OrderItemDTO> findAll(Pageable pageable) {
        Page<OrderItem> orderItems = repository.findAll(pageable);
        return orderItems.map(x -> new OrderItemDTO(x));
    }

    public OrderItemDTO insert(OrderItemDTO dto) {
        OrderItem entity = new OrderItem();
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return new OrderItemDTO(entity);
    }

    public OrderItemDTO update(Long id, OrderItemDTO dto) {
        try {
            OrderItem entity = repository.getReferenceById(id);
            copyDtoToEntity(entity, dto);
            entity = repository.save(entity);
            return new OrderItemDTO(entity);
        }catch (RuntimeException e){
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.
                    EntityNotFoundException("Entity not found");
        }
    }

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

    private void copyDtoToEntity(OrderItem entity, OrderItemDTO dto) {

        entity.setQuantity(dto.getQuantity());
        entity.setUnitaryPrice(dto.getUnitaryPrice());

        if (dto.getOrderId() != null){
            Order order = orderRepository.findById(dto.getOrderId()).
                    orElseThrow(()-> new com.jsoftwar.controle.de.pedidos.services.exceptions.
                            EntityNotFoundException("Entity not Found"));

            entity.setOrder(order);
        }

        if (dto.getProductId() != null){
            Product product = productRepository.findById(dto.getProductId()).
                    orElseThrow(()-> new com.jsoftwar.controle.de.pedidos.services.exceptions.
                            EntityNotFoundException("Entity not Found"));

            entity.setProduct(product);
        }
    }
}
