package vct.freshshop.service.in;

import java.util.Optional;

import vct.freshshop.dto.CategoryDTO;
import vct.freshshop.entity.Category;

public interface CategoryServiceInterface extends AbstractServiceInterface<Category>{

	Optional<Category> findByTitle(String name);
	CategoryDTO convertToDTO(Category category);
}
