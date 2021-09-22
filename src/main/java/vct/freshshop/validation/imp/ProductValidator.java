package vct.freshshop.validation.imp;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


import vct.freshshop.entity.Product;
import vct.freshshop.service.in.ProductServiceInterface;
import vct.freshshop.validation.in.CheckProduct;

public class ProductValidator implements ConstraintValidator<CheckProduct, Product>{

	@Autowired
	private ProductServiceInterface productService;
	
	@Override
	public boolean isValid(Product value, ConstraintValidatorContext context) {
		return true;
	}

	public boolean checkProductIdExits(int id) {
		Optional<Product> product = productService.findById(id);
		return product.isPresent();
	}
}
