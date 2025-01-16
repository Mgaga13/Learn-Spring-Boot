package vn.tayjava.dto.validator;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import vn.tayjava.util.Gender;

@Documented
@Target({METHOD,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = GenderSubSetValidator.class)
public @interface GenderSubset {
  Gender[] anyOf();
  String message() default "must have {anyOf}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
