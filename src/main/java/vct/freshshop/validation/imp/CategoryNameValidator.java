package vct.freshshop.validation.imp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import vct.freshshop.service.in.CategoryServiceInterface;
import vct.freshshop.validation.in.CheckCategoryName;

public class CategoryNameValidator implements ConstraintValidator<CheckCategoryName, String>{

	@Autowired
	private CategoryServiceInterface categoryService;
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !categoryService.findByTitle(value).isPresent();
	}
}
