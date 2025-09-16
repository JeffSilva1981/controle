package com.jsoftwar.controle.de.pedidos.services;

import com.jsoftwar.controle.de.pedidos.DTO.ProductDTO;
import com.jsoftwar.controle.de.pedidos.entities.Product;
import com.jsoftwar.controle.de.pedidos.repositories.ProductRepository;
import com.jsoftwar.controle.de.pedidos.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product entity = repository.findById(id).orElseThrow(()->
                new com.jsoftwar.controle.de.pedidos.services.exceptions.EntityNotFoundException("Entity not found"));

        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> entity = repository.findAll(pageable);
        return entity.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }catch (EntityNotFoundException e){
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.EntityNotFoundException("Entity not Found");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.EntityNotFoundException("Entity not Found");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity Violation");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setLimitPerCustomer(dto.getLimitPerCustomer());
    }
}
