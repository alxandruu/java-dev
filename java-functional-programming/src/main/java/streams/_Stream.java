package streams;

import functional.programming.beans.Person;

import static functional.programming.types.Gender.*;

import java.util.List;

public class _Stream {

    public static void main(String[] args) {
        final var people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Gabriel", MALE),
                new Person("Carmen", FEMALE)
        );

        // people.stream()
        //       .map(Person::getName).map(String::length).forEach(System.out::println);

        var containsOnlyFemales = people.stream().allMatch(Person::isFemale);

        var containsFemale = people.stream().anyMatch(Person::isFemale);

        System.out.println(containsOnlyFemales);
        System.out.println(containsFemale);
    }
}
