package com.surpricecars.opentravelservice.services.validation;

import com.surpricecars.opentravelservice.exceptions.SOAPValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;


public interface Valid<T> {

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    default void validate() throws SOAPValidationException {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new SOAPValidationException(violations.toString());
        }
    }

}
