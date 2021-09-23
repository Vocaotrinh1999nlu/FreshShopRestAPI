package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.entity.Customer;
import vct.freshshop.repositories.CustomerRepository;
import vct.freshshop.service.in.CustomerServiceInterface;
@Service
public class CustomerService implements CustomerServiceInterface{

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findById(int id) {
		return customerRepository.findById(id);
	}

	@Override
	public void save(Customer t) {
		customerRepository.save(t);
	}

	@Override
	public void update(Customer t1, Customer t2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExistById(int id) {
		return customerRepository.existsById(id);
	}

}
