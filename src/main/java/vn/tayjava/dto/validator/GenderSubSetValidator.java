package vn.tayjava.dto.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import vn.tayjava.util.Gender;

public class GenderSubSetValidator implements ConstraintValidator<GenderSubset, Gender> {
  private  Gender [] genders;

  @Override
  public void initialize(GenderSubset constraintAnnotation) {
    this.genders=constraintAnnotation.anyOf();
  }

  @Override
  public boolean isValid(Gender value, ConstraintValidatorContext context) {
    return value==null|| Arrays.asList(genders).contains(value);
  }
}
