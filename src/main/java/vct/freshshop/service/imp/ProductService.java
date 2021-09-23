package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.dto.CategoryDTO;
import vct.freshshop.dto.ProductDTO;
import vct.freshshop.entity.Category;
import vct.freshshop.entity.Product;
import vct.freshshop.exception.NullPointerException;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.repositories.CategoryRepository;
import vct.freshshop.repositories.ProductRepository;
import vct.freshshop.service.in.CategoryServiceInterface;
import vct.freshshop.service.in.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface{

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryServiceInterface categoryService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public void save(Product product) {
		Optional<Category> category = categoryService.findById(product.getCategory().getId());
		category.ifPresentOrElse(c->product.setCategory(c), ()-> categoryService.save(product.getCategory()));
		productRepository.save(product);
		
	}

	@Override
	public void update(Product product, Product newProduct) {// p is new product
		Optional<Category> category = categoryService.findById(product.getCategory().getId());
		category.ifPresentOrElse(c->product.setCategory(c), ()-> categoryService.save(newProduct.getCategory()));
		modelMapper.map(newProduct, product);
		productRepository.save(product);
	}
	
	@Override
	public void remove(Product product) {
		productRepository.delete(product);
	}

	@Override
	public boolean isExistById(int id) {
		return !productRepository.existsById(id);
	}
}
