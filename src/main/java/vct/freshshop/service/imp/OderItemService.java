package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.entity.OderItem;
import vct.freshshop.repositories.OderItemRepository;
import vct.freshshop.service.in.OderItemServiceInterface;
import vct.freshshop.service.in.ProductServiceInterface;

@Service
public class OderItemService implements OderItemServiceInterface {

	@Autowired
	private OderItemRepository oderItemRepository;

	@Autowired
	private ProductServiceInterface productService;
	
	@Autowired
	private OderItemServiceInterface oderServiceInterface;
	
	@Override
	public List<OderItem> findAll() {
		return oderItemRepository.findAll();
	}

	@Override
	public Optional<OderItem> findById(int id) {
		return oderItemRepository.findById(id);
	}

	@Override
	public void save(OderItem t) {
		
	}

	@Override
	public void update(OderItem t1, OderItem t2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(OderItem t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
