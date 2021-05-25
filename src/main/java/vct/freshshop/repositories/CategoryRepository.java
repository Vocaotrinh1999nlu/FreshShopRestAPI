package vct.freshshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vct.freshshop.entity.Category;
import vct.freshshop.entity.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT c FROM Category c where c.title = ?1")
	public Category getCategoryByName(String name);
	
	@Query("SELECT c FROM Category c where c.id = ?1")
	public Category getCategoryBId(int id);
	
	@Query("SELECT c.products FROM Category c where c.id=?1")
	public List<Product> findByProduct(int id); 
}
