package functional.programming;

import functional.programming.beans.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        final var maria = new Customer("Maria", "999991");

        //Normal Java Function
        greetCustomer(maria);

        // Consumer Functional Interface
        greetCustomerConsumer.accept(maria);

        // BiConsumer Functional Interface
        greetCustomerBiConsumer.accept(maria, true);
    }

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, hidePhoneNumber) -> System.out.printf(
            "Hello %s thanks for registering phone number %s%n",
            customer.getName(),
            hidePhoneNumber ? "*********" : customer.getPhoneNumber()
    );

    static Consumer<Customer> greetCustomerConsumer = customer ->  System.out.printf(
            "Hello %s thanks for registering phone number %s%n",
            customer.getName(),
            customer.getPhoneNumber()
    );

    static void greetCustomer(Customer customer) {
        System.out.printf(
                "Hello %s thanks for registering phone number %s%n",
                customer.getName(),
                customer.getPhoneNumber()
        );
    }

}
