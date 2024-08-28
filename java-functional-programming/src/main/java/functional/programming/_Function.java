package functional.programming;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        final var increment = increment(0);
        System.out.println(increment);

        final var functionCombined = incrementByOne.andThen(multiplyBy10);
        System.out.println(functionCombined.apply(2));

        final var resultTwo = incrementByOne.apply(24);
        System.out.println(resultTwo);

        final var resultThree = multiplyBy10.apply(20);
        System.out.println(resultThree);

        final var resultSplit = splitBy.apply("texto1,texto2,yjygj", ",");
        resultSplit.forEach(System.out::println);
    }

    // BiFunction<T, U, R>
    static BiFunction<String, String, List<String>> splitBy = (cadena, regex) -> List.of(cadena.split(regex));

    static List<String> splitByFc(String cadena, String regex) {
        return List.of(cadena.split(regex));
    }

    // Function<T, R>
    static Function<String, List<String>> splitByComma = v -> List.of(v.split(","));
    static Function<Integer, Integer> incrementByOne = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }
}
