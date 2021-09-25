package vct.freshshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vct.freshshop.dto.ProductDTO;
import vct.freshshop.dto.ProductDTOV2;
import vct.freshshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
