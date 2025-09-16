package com.jsoftwar.controle.de.pedidos.DTO;
import com.jsoftwar.controle.de.pedidos.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String image;
    private Integer limitPerCustomer;

    public ProductDTO(){

    }

    public ProductDTO(Long id, String name, BigDecimal price,
                      Integer stock, String description,
                      String image, Integer limitPerCustomer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.image = image;
        this.limitPerCustomer = limitPerCustomer;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        stock = entity.getStock();
        description = entity.getDescription();
        image = entity.getImage();
        limitPerCustomer = entity.getLimitPerCustomer();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Integer getLimitPerCustomer() {
        return limitPerCustomer;
    }
}
