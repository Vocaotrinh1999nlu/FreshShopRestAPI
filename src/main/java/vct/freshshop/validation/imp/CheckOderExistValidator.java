package vct.freshshop.validation.imp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import vct.freshshop.entity.Oder;
import vct.freshshop.service.in.OderServiceInterface;
import vct.freshshop.validation.in.CheckOderExist;

public class CheckOderExistValidator implements ConstraintValidator<CheckOderExist, Oder>{

	@Autowired
	private OderServiceInterface oderService;
	@Override
	public boolean isValid(Oder value, ConstraintValidatorContext context) {
		return !oderService.isExistById(value.getId());
	}

}
