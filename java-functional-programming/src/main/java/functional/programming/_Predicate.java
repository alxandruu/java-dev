package functional.programming;

import java.util.Objects;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("0034123123123"));
        System.out.println(isPhoneNumberValid("0014123123123"));

        // Predicate Functional Interface
        System.out.println("Predicate -> " + isPhoneNumberValidPredicate.test("0034123123123"));
        System.out.println("Predicate -> " + isPhoneNumberValidPredicate.test("0014123123123"));

        System.out.println("Predicate and-> " + isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("0014123123123"));
        System.out.println("Predicate and-> " + isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("0034000000000"));
        System.out.println("Predicate or-> " + isPhoneNumberValidPredicate.or(containsNumberThreePredicate).test("003411"));

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("0034") && Objects.equals(phoneNumber.length(), 13);
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("0034") && Objects.equals(phoneNumber.length(), 13);

    static Predicate<String> containsNumberThreePredicate = phoneNumber -> phoneNumber.contains("3");
}
