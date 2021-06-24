package CourseBookingLab.CourseBookingLab.controllers;

import CourseBookingLab.CourseBookingLab.models.Customer;
import CourseBookingLab.CourseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, name="course") String course
    ){
        if(course != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }else{
            List<Customer> foundCustomers = customerRepository.findAll();
            return new ResponseEntity<>(foundCustomers, HttpStatus.OK);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id){
        Optional<Customer> foundFile = customerRepository.findById(id);
        return new ResponseEntity(foundFile, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
