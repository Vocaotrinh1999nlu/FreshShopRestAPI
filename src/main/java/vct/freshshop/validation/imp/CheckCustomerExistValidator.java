package vct.freshshop.validation.imp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import vct.freshshop.entity.Customer;
import vct.freshshop.service.in.CustomerServiceInterface;
import vct.freshshop.validation.in.CheckCustomerExist;

public class CheckCustomerExistValidator implements ConstraintValidator<CheckCustomerExist, Customer>{

	@Autowired
	private CustomerServiceInterface customerService;
	
	@Override
	public boolean isValid(Customer value, ConstraintValidatorContext context) {
		return !customerService.isExistById(value.getId());
	}

}
