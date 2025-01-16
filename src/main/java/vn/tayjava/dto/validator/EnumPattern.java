package vn.tayjava.dto.validator;


import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE,
    CONSTRUCTOR, PARAMETER})
@Constraint(validatedBy = EnumPatternValidator.class)
public @interface EnumPattern {
  String name();
  String regexp();
  String message() default "{name} must have {regexp}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
