package com.jsoftwar.controle.de.pedidos.DTO;

import com.jsoftwar.controle.de.pedidos.entities.Customer;

public class CustomerDTO {

    private Long id;
    private String name;
    private String cellPhone;
    private String image;

    public CustomerDTO(){

    }

    public CustomerDTO(Long id, String name, String cellPhone, String image) {
        this.id = id;
        this.name = name;
        this.cellPhone = cellPhone;
        this.image = image;
    }

    public CustomerDTO(Customer entity){
        id = entity.getId();
        name = entity.getName();
        cellPhone = entity.getCellPhone();
        image = entity.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
