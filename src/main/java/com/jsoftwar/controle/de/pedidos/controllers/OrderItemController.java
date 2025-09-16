package com.jsoftwar.controle.de.pedidos.controllers;

import com.jsoftwar.controle.de.pedidos.DTO.OrderItemDTO;
import com.jsoftwar.controle.de.pedidos.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

   @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> findById(@PathVariable Long id){
        OrderItemDTO dto = orderItemService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<OrderItemDTO>> findAll(Pageable pageable){
       Page<OrderItemDTO> dtos = orderItemService.findAll(pageable);
       return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> insert(@Validated @RequestBody OrderItemDTO dto){
       dto = orderItemService.insert(dto);
       return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> update(@PathVariable Long id, @Validated @RequestBody OrderItemDTO dto){
        dto = orderItemService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<OrderItemDTO> delete(@PathVariable Long id){
       orderItemService.delete(id);
       return ResponseEntity.noContent().build();
    }


}
