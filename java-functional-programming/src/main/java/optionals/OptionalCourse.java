package optionals;

import java.util.Optional;

public class OptionalCourse {
    public static void main(String[] args) {
        var value = Optional.ofNullable("Hello").orElse("default value");
        System.out.println(value);

        Optional.ofNullable("Hello").ifPresent(v -> {
                    System.out.println("Sending email to " + v);
                }
        );
    }
}
