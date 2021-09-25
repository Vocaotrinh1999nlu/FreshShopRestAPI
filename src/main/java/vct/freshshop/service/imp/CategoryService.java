package vct.freshshop.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vct.freshshop.dto.CategoryDTO;
import vct.freshshop.dto.ProductDTO;
import vct.freshshop.dto.ProductDTOV2;
import vct.freshshop.entity.Category;
import vct.freshshop.repositories.CategoryRepository;
import vct.freshshop.service.in.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Optional<Category> findById(int id){
		return categoryRepository.findById(id);
	}
	
	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	@Override
	public void update(Category category,Category newCategory) {
		modelMapper.map(newCategory, category);
		categoryRepository.save(category);
	}
	
	@Override
	public void remove(Category category) {
		categoryRepository.delete(category);
	}
	
	public Optional<Category> findByTitle(String name){
		return categoryRepository.findByTitle(name);
	}

	@Override
	public boolean isExistById(int id) {
		return categoryRepository.existsById(id);
	}

	@Override
	public CategoryDTO convertToDTO(Category category) {
		List<ProductDTOV2> products = category.getProducts().stream().map(p-> modelMapper.map(p, ProductDTOV2.class)).collect(Collectors.toList());
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		categoryDTO.setProducts(products);
		return categoryDTO;
	}
	
	
}
