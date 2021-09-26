package me.gabreuw.reactive;

import java.util.stream.IntStream;

public class PrintSteams {

    public static void main(String[] args) {
        IntStream.of(1, 2, 3)
                .forEach(System.out::println);
    }

}
