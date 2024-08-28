package combinator.pattern;


import combinator.pattern.beans.Customer;
import combinator.pattern.types.ValidationResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;


public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@")
                ? ValidationResult.SUCCESS
                : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> (customer.getPhoneNumber().replaceAll("\\s", "").startsWith("0034")
                || customer.getPhoneNumber().replaceAll("\\s", "").startsWith("+34"))
                ? ValidationResult.SUCCESS
                : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 17
                ? ValidationResult.SUCCESS
                : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            var result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }
}
