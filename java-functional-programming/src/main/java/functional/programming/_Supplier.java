package functional.programming;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getUrlConnection());
        System.out.println(getUrlConnectionSupplier.get());
    }

    static String getUrlConnection() {
        return "https://api.endpoint.v1/users";
    }


    static Supplier<List<String>> getUrlConnectionSupplier = () ->  List.of( "https://api.endpoint.v1/users");
}
