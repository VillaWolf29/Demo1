package com.example.controller;

import com.example.dto.CustomerDTO;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.ServiceConfigurationError;

@RestController
@RequestMapping("/customers")
//@CrossOrigin(origins = "*")
//@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerController {
    //@Autowired
    private final ICustomerService service;
    private final ModelMapper modelMapper;

    // http://localhost:9090/customers
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        //List<Customer> list=service.findAll();
        /*List<CustomerDTO> list = service.findAll().stream().map(e -> new CustomerDTO(
                e.getIdCustomer(),e.getFirstName(),e.getLastName(),e.getPhone(),e.getEmail(),e.getDni(),e.getAddress()
        )).toList();*/
        //List<CustomerDTO> list = service.findAll().stream().map(e ->modelMapper.map(e, CustomerDTO.class)).toList();
        List<CustomerDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }
    // http://localhost:9090/customers/5
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id) throws Exception{
        //Customer obj = service.findById(id);
        //CustomerDTO obj = modelMapper.map(service.findById(id), CustomerDTO.class);
        CustomerDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }
    // http://localhost:9090/customers
    @PostMapping
    public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO dto) throws Exception{
        //Customer obj = service.save(customer);
        //Customer obj = service.save(modelMapper.map(dto, Customer.class));
        Customer obj = service.save(convertToEntity(dto));
        //return ResponseEntity.ok(obj);
        //localhost:9090/customers/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCustomer()).toUri();
        //return new ResponseEntity<>(obj, HttpStatus.CREATED);
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO dto, @PathVariable("id") Integer id) throws Exception{

        //Customer obj = service.update(modelMapper.map(dto,Customer.class),id);
        Customer obj = service.update(convertToEntity(dto),id);
        CustomerDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CustomerDTO convertToDto(Customer obj){
        return modelMapper.map(obj, CustomerDTO.class);
    }
    private Customer convertToEntity(CustomerDTO dto){
        return modelMapper.map(dto, Customer.class);
    }



    /*private String atributoEjemplo;

    /*public CustomerController(ICustomerService serviceo) {
        this.service = service;
    }*/

    /*@GetMapping
   public Customer saveCustomer() {
        //service = new CustomerService();
        //return new Customer (1,"John Doe");
        return service.validAndSave(new Customer ());
   }*/
}
