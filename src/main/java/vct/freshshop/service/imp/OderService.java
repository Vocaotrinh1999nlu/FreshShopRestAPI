package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vct.freshshop.entity.Customer;
import vct.freshshop.entity.Oder;
import vct.freshshop.entity.OderItem;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.repositories.OderItemRepository;
import vct.freshshop.repositories.OderRepository;
import vct.freshshop.service.in.CustomerServiceInterface;
import vct.freshshop.service.in.OderItemServiceInterface;
import vct.freshshop.service.in.OderServiceInterface;

@Service
public class OderService implements OderServiceInterface{

	@Autowired
	private OderRepository oderRepository;

	@Autowired
	private CustomerServiceInterface customerService;
	
	@Override
	public List<Oder> findAll() {
		return oderRepository.findAll();
	}

	@Override
	public Optional<Oder> findById(int id) {
		return oderRepository.findById(id);
	}

	@Override
	public void save(Oder t) {
		t.setCustomer(customerService.findById(t.getCustomer().getId()).get());
		oderRepository.save(t);
	}

	@Override
	public void update(Oder t1, Oder t2) {
		
		
	}

	@Override
	public void remove(Oder t) {
		oderRepository.delete(t);
	}

	@Override
	public boolean isExistById(int id) {
		return !oderRepository.existsById(id);
	}
	

}
