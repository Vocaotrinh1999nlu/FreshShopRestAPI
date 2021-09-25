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

import vct.freshshop.dto.CategoryDTO;
import vct.freshshop.entity.Category;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.service.in.CategoryServiceInterface;

@RequestMapping("/api")
@RestController
public class CategoryController {

	@Autowired
	private CategoryServiceInterface categoryService;
	
	@GetMapping("/category")
	public ResponseEntity<Object> getAllCategory(){
		List<CategoryDTO> categories = categoryService.findAll()
				.stream().map(c -> categoryService.convertToDTO(c)).collect(Collectors.toList());
		return new ResponseEntity<Object>(categories,HttpStatus.OK);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") int id) {
		Optional<CategoryDTO> category = categoryService.findById(id).map(c -> categoryService.convertToDTO(c));
		return category.map(c -> new ResponseEntity<CategoryDTO>(c, HttpStatus.OK))
				.orElseThrow(() -> new ResourceNotFoundException("Category not found"));
	}
	
	@PostMapping("/category")
	public ResponseEntity<String> addCategory(@Valid @RequestBody Category category){
		categoryService.save(category);
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<String> updateCategory(@Valid @RequestBody Category newCategory, @PathVariable("id") int id){
		Optional<Category> category = categoryService.findById(id);
		return category.map(c->{
			categoryService.update(c, newCategory);
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
		}).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
		Optional<Category> category = categoryService.findById(id);
		return category.map(c->{
			categoryService.remove(c);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		}).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
	}
}
