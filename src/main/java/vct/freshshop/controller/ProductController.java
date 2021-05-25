package vct.freshshop.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.entity.Product;
import vct.freshshop.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Optional<Product> product = productService.findById(id);
		if (product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping("/product")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		try {
			productService.addProduct(product);
			return new ResponseEntity<String>("Created", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Not sucess", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product newProduct){
		Optional<Product> product = productService.findById(id);
		if(product.isPresent()) {
			productService.updateProduct(product.get(), newProduct);
			return new ResponseEntity<String>("Updated",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id){
		Optional<Product> product = productService.findById(id);
		if(product.isPresent()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	}
}
