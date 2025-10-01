package com.jsoftwar.controle.de.pedidos.services;

import com.jsoftwar.controle.de.pedidos.DTO.CustomerDTO;
import com.jsoftwar.controle.de.pedidos.entities.Customer;
import com.jsoftwar.controle.de.pedidos.entities.Role;
import com.jsoftwar.controle.de.pedidos.projections.UserDetailsProjection;
import com.jsoftwar.controle.de.pedidos.repositories.CustomerRepository;
import com.jsoftwar.controle.de.pedidos.services.exceptions.DatabaseException;
import com.jsoftwar.controle.de.pedidos.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public CustomerDTO findById(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new com.jsoftwar.controle.de.pedidos.services.exceptions.
                EntityNotFoundException("Entity not Found" + id));
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
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.
                    EntityNotFoundException("Entity not Found" + id);
        }
    }

    public void delete(Long id) {
        if (!customerRepository.existsById(id)){
            throw new com.jsoftwar.controle.de.pedidos.services.exceptions.
                    EntityNotFoundException("Entity not Found" + id);
        }
        try {
            customerRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity Violation");
        }

    }

    private void copyDTOtoEntity(CustomerDTO dto, Customer entity) {
        entity.setName(dto.getName());
        entity.setCellPhone(dto.getCellPhone());
        entity.setImage(dto.getImage());

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = customerRepository.searchUserAndRolesByEmail(username);
        if (result.size() == 0){
            throw new UsernameNotFoundException("User not found");
        }
        Customer customer = new Customer();
        customer.setCellPhone(username);
        customer.setPassword(result.get(0).getPassword());

        for (UserDetailsProjection projection : result){
            customer.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return customer;
    }
}
