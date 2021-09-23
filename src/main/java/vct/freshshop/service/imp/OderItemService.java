package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.entity.Oder;
import vct.freshshop.entity.OderItem;
import vct.freshshop.entity.Product;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.repositories.OderItemRepository;
import vct.freshshop.service.in.OderItemServiceInterface;
import vct.freshshop.service.in.OderServiceInterface;
import vct.freshshop.service.in.ProductServiceInterface;

@Service
public class OderItemService implements OderItemServiceInterface {

	@Autowired
	private OderItemRepository oderItemRepository;

	@Autowired
	private ProductServiceInterface productService;

	@Autowired
	private OderServiceInterface oderService;

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
		System.out.println(t.getProduct().getId());
		Optional<Product> product = productService.findById(t.getProduct().getId());
		Optional<Oder> oder = oderService.findById(t.getOder().getId());
		product.ifPresentOrElse(p -> t.setProduct(p),
				() -> new ResourceNotFoundException("Not found product for save oderItem"));
		oder.ifPresentOrElse(o -> t.setOder(o),
				() -> new ResourceNotFoundException("Not found oder for save oderItem"));
		boolean isProductExist = product.isPresent();
		boolean isOderExist = oder.isPresent();
		if(isProductExist && isOderExist) {
			t.setProduct(product.get());
			t.setOder(oder.get());
			oderItemRepository.save(t);
		}
	}

	@Override
	public void update(OderItem t1, OderItem t2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(OderItem t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExistById(int id) {
		return oderItemRepository.existsById(id);
	}

}
