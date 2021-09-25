package vct.freshshop.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.dto.ProductDTO;
import vct.freshshop.dto.ProductDTOV2;
import vct.freshshop.entity.Product;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.service.in.ProductServiceInterface;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductServiceInterface productService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/product")
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		List<ProductDTO> products = productService.findAll().stream()
				.map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int id) {
		Optional<Product> product = productService.findById(id);
		Optional<ProductDTO> productDTO = product.map(p -> modelMapper.map(p, ProductDTO.class));
		return productDTO.map(p -> new ResponseEntity<ProductDTO>(p, HttpStatus.OK))
				.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@PostMapping("/product")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
		productService.save(product);
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product newProduct) {
		Optional<Product> product = productService.findById(id);
		return product.map(p -> {
			productService.update(p, newProduct);
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found product"));
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id) {
		Optional<Product> product = productService.findById(id);
		return product.map(p -> {
			productService.remove(p);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

}
