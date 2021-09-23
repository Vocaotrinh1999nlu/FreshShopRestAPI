package vct.freshshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.entity.Customer;
import vct.freshshop.service.in.CustomerServiceInterface;

@RequestMapping("/api")
@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<String> save(@Valid @RequestBody Customer customer){
		customerService.save(customer);
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
}
