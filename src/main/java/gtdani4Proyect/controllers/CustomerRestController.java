package gtdani4Proyect.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import gtdani4Proyect.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/clientes")
public class CustomerRestController {

    // Lista de clientes
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(1, "Juan", "juanito", "1234"),
        new Customer(2, "Pedro", "pedrito", "1234"),
        new Customer(3, "Maria", "maria", "1234")
    ));   

    // Endpoint para obtener la lista de clientes 
    // Alternativa (ambas funcionan igual) a poner @GetMapping -> @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getCustomers() {
        return customers;
    }

    // Endpoint para obtener los datos de un cliente
    // Alternativa (ambas funcionan igual) a poner @GetMapping -> @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;  
            }  
        }
        return null;  
    }

    // Endpoint para añadir un cliente
    // Alternativa (ambas funcionan igual) a poner @PostMapping -> @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }
    
    // Endpoint para modificar datos de un cliente
    // Alternativa (ambas funcionan igual) a poner @PutMapping -> @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public Customer putCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {     
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }

    // Endpoint para modificar un dato en conceto de un cliente
    // Alternativa (ambas funcionan igual) a poner @PatchMapping -> @RequestMapping(method = RequestMethod.PATCH)
    @PatchMapping
    public Customer patchCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {     
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }

    // Endpoint para modificar datos de un cliente
    // Alternativa (ambas funcionan igual) a poner @DeleteMapping -> @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for (Customer c : customers) {
            if (c.getID() == id) {  
                customers.remove(c);

                return c;
            }
        }
        return null;
    }
 
}