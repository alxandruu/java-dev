package combinator.pattern;

import combinator.pattern.beans.Customer;
import combinator.pattern.types.ValidationResult;

import java.time.LocalDate;

import static combinator.pattern.CustomerRegistrationValidator.*;
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+ 34 652 576 987",
                LocalDate.of(2000, 1, 1));
        // final var validatorService = new CustomerValidatorService();
        // System.out.println(validatorService.isValid(customer));

        // Using Combinator Pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
        if(ValidationResult.SUCCESS != result){
            throw new IllegalStateException(result.name());
        }
    }
}
