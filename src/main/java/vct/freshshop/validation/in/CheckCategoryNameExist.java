package vct.freshshop.validation.in;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import vct.freshshop.dto.CategoryDTO;
import vct.freshshop.validation.imp.CheckCategoryNameExistValidator;
import vct.freshshop.validation.imp.CheckProductExistValidator;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckCategoryNameExistValidator.class)
@Documented
public @interface CheckCategoryNameExist {

	String message() default "Category name is exits.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
