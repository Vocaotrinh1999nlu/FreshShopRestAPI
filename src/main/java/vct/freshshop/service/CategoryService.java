package vct.freshshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.entity.Category;
import vct.freshshop.entity.Product;
import vct.freshshop.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public List<Product> getProductByCategory(int id){
		return categoryRepository.findByProduct(id);
	}
	public Optional<Category> findById(int id){
		return categoryRepository.findById(id);
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
}
