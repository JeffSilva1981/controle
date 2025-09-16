package com.jsoftwar.controle.de.pedidos.DTO;

import com.jsoftwar.controle.de.pedidos.entities.Customer;
import com.jsoftwar.controle.de.pedidos.entities.Order;
import com.jsoftwar.controle.de.pedidos.entities.OrderItem;
import com.jsoftwar.controle.de.pedidos.entities.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Long id;
    private LocalDateTime dateOfOrder;
    private OrderStatus status;
    private BigDecimal totalValue;
    private String proofOfPayment;
    private Long customerId;

    private List<OrderItemDTO> items;

    public OrderDTO(){

    }

    public OrderDTO(Order entity){
        this.id = entity.getId();
        this.dateOfOrder = entity.getOrderDate();
        this.status = entity.getStatus();
        this.totalValue = entity.getTotalValue();
        this.proofOfPayment = entity.getProofOfPayment();

        Customer customer = entity.getCustomer();
        this.customerId = (customer != null ? customer.getId(): null);

        this.items = entity.getItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDateTime dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getProofOfPayment() {
        return proofOfPayment;
    }

    public void setProofOfPayment(String proofOfPayment) {
        this.proofOfPayment = proofOfPayment;
    }

    public Long getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(Long customer_id) {
        this.customerId = customer_id;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
