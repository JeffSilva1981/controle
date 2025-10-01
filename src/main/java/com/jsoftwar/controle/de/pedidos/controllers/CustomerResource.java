package com.jsoftwar.controle.de.pedidos.controllers;

import com.jsoftwar.controle.de.pedidos.DTO.CustomerDTO;
import com.jsoftwar.controle.de.pedidos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    public CustomerService customerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id){
        CustomerDTO customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> findAll(Pageable pageable){
        Page<CustomerDTO> customerDTOPage = customerService.findAll(pageable);
        return ResponseEntity.ok(customerDTOPage);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> insertCustomer (@Validated @RequestBody CustomerDTO dto){
        dto = customerService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id,@Validated @RequestBody CustomerDTO dto){
        dto = customerService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
