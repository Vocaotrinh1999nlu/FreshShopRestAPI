package vct.freshshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vct.freshshop.dto.ProductDTO;
import vct.freshshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.id = ?1")
	public Product getProductById(int id);
}
