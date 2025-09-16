package com.jsoftwar.controle.de.pedidos.services.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String msn){
        super(msn);
    }

}
