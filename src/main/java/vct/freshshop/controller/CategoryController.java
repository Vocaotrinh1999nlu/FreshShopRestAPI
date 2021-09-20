package vct.freshshop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.dto.CategoryDTO;
import vct.freshshop.entity.Category;
import vct.freshshop.entity.Product;
import vct.freshshop.service.CategoryService;

@RequestMapping("/api")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/category")
	public ResponseEntity<Object> getAllCategory(){
		List<CategoryDTO> categories = categoryService.getAllCategory()
				.stream().map(c -> modelMapper.map(c, CategoryDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<Object>(categories,HttpStatus.OK);
	}
	
	@GetMapping("/getProductByCategory/{id}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("id") int id){
		List<Product> products = categoryService.getProductByCategory(id);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
