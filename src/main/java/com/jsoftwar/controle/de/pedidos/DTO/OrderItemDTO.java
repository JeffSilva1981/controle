package com.jsoftwar.controle.de.pedidos.DTO;

import com.jsoftwar.controle.de.pedidos.entities.OrderItem;
import com.jsoftwar.controle.de.pedidos.entities.Product;

import java.math.BigDecimal;

public class OrderItemDTO {

    private Long id;
    private Integer quantity;
    private BigDecimal unitaryPrice;
    private Long productId;
    private Long orderId;

    public OrderItemDTO(){

    }

    public OrderItemDTO(OrderItem entity){
        id = entity.getId();
        quantity = entity.getQuantity();
        unitaryPrice = entity.getUnitaryPrice();

        this.productId = (entity.getProduct() != null ? entity.getProduct().getId() : null);
        this.orderId = (entity.getOrder() != null ? entity.getOrder().getId() : null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(BigDecimal unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
