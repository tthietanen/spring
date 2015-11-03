package fi.agileo.spring.e15.bean.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlkaaIsollakirjaimellaValidator implements
		ConstraintValidator<AlkaaIsollakirjaimella, String> {

	public void initialize(AlkaaIsollakirjaimella alkaaIsollakirjaimella) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}

		if (Character.isUpperCase(value.charAt(0)) == true) {
			return true;
		}

		return false;
	}
}