package com.example.modernjavainaction.ch05;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreamExample {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);

        Stream<String> nullableStream = Stream.ofNullable(null);
        nullableStream.forEach(System.out::println);

        int[] numbers = { 2, 3, 5, 7, 11, 13 };
        System.out.println(Arrays.stream(numbers).sum());
    }
}
