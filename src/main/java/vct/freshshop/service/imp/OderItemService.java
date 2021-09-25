package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.dto.OderItemDTO;
import vct.freshshop.dto.ProductDTO;
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

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<OderItem> findAll() {
		List<OderItem> oderItem = oderItemRepository.findAll();
		return oderItem;
	}

	@Override
	public Optional<OderItem> findById(int id) {
		return oderItemRepository.findById(id);
	}

	@Override
	public void save(OderItem t) {
		//Because i have checked product and order is exist in validation, I'm not check in here.
		t.setProduct(productService.findById(t.getId()).get());
		t.setOder(oderService.findById(t.getId()).get());
		oderItemRepository.save(t);
	}

	@Override
	public void update(OderItem oldOderItem, OderItem newOderItem) {
		//not update oder and product in oder item
		//just update quantity
		oldOderItem.setQuantity(newOderItem.getQuantity());
		oderItemRepository.save(oldOderItem);
	}

	@Override
	public void remove(OderItem t) {
		oderItemRepository.delete(t);
	}

	@Override
	public boolean isExistById(int id) {
		return oderItemRepository.existsById(id);
	}

	@Override
	public OderItemDTO convertToDTO(OderItem o) {
		ProductDTO productDTO= modelMapper.map(o.getProduct(), ProductDTO.class);
		OderItemDTO oderItemDTO = modelMapper.map(o, OderItemDTO.class);
		oderItemDTO.setProduct(productDTO);
		return oderItemDTO;
	}

}
