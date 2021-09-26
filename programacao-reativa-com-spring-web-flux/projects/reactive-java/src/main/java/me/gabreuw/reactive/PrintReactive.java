package me.gabreuw.reactive;

import io.reactivex.Flowable;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PrintReactive {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1, 1, SECONDS)
                .map(n -> n * 2)
                .subscribe(System.out::println);

        SECONDS.sleep(3);
    }

}
