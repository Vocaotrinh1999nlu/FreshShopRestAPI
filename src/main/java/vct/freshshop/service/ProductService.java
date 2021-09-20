package vct.freshshop.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.dto.ProductDTO;
import vct.freshshop.entity.Category;
import vct.freshshop.entity.Product;
import vct.freshshop.repositories.CategoryRepository;
import vct.freshshop.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ModelMapper modelMapper;

	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public void addProduct(Product product) {
		Optional<Category> category = categoryService.findById(product.getCategory().getId());
		if (category.isPresent()) { // if category exist
			product.setCategory(category.get());
			System.out.println("Add product with category exists");
		} else {
			categoryRepository.save(product.getCategory());// add new category
			System.out.println("Add product with category not exist");
		}
		productRepository.save(product);
	}

	public void updateProduct(Product product, Product newProduct) {// p is new product
		modelMapper.map(newProduct, product);
		productRepository.save(product);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}
