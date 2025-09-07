package com.jsoftwar.controle.de.pedidos.services;

import com.jsoftwar.controle.de.pedidos.DTO.CustomerDTO;
import com.jsoftwar.controle.de.pedidos.controllers.handlers.CustomerNotFoundException;
import com.jsoftwar.controle.de.pedidos.entities.Customer;
import com.jsoftwar.controle.de.pedidos.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public CustomerDTO findById(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        return new CustomerDTO(customer);
    }

    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAll(Pageable pageable){
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.map(x -> new CustomerDTO(x));

    }

    @Transactional
    public CustomerDTO insert(CustomerDTO dto) {
        Customer entity = new Customer();
        copyDTOtoEntity(dto, entity);
        entity = customerRepository.save(entity);
        return new CustomerDTO(entity);
    }

    @Transactional
    public CustomerDTO update(Long id, CustomerDTO dto) {
        try {
            Customer entity = customerRepository.getReferenceById(id);
            copyDTOtoEntity(dto, entity);
            entity = customerRepository.save(entity);
            return new CustomerDTO(entity);
        }catch (RuntimeException e){
            throw new CustomerNotFoundException("Id do cliente não encontrado");
        }
    }

    public void delete(Long id) {
        if (!customerRepository.existsById(id)){
            throw new CustomerNotFoundException("Id do cliente não encontrado");
        }

        customerRepository.deleteById(id);
    }

    private void copyDTOtoEntity(CustomerDTO dto, Customer entity) {
        entity.setName(dto.getName());
        entity.setCellPhone(dto.getCellPhone());
        entity.setImage(dto.getImage());

    }
}
