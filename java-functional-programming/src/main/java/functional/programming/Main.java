package functional.programming;

import functional.programming.beans.Person;
import functional.programming.types.Gender;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final var people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Gabriel", Gender.MALE),
                new Person("Carmen", Gender.FEMALE)
        );

        System.out.println("// Declarative approach");


        final Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());

        final var females = people.stream().filter(person -> Gender.FEMALE.equals(person.getGender()))
                .collect(Collectors.toList());
        females.forEach(System.out::println);
    }
}