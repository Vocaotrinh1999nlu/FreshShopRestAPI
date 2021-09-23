package vct.freshshop.validation.imp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import vct.freshshop.entity.Product;
import vct.freshshop.service.in.ProductServiceInterface;
import vct.freshshop.validation.in.CheckProductExist;

public class CheckProductExistValidator implements ConstraintValidator<CheckProductExist, Product>{

	@Autowired
	private ProductServiceInterface productService;
	
	@Override
	public boolean isValid(Product value, ConstraintValidatorContext context) {
		return !productService.isExistById(value.getId());
	}
}
