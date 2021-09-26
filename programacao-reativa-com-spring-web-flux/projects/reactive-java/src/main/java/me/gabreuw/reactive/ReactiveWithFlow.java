package me.gabreuw.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;

class CustomSubscriber implements Flow.Subscriber<Integer> {

    private final Logger logger = Logger.getAnonymousLogger();

    private Flow.Subscription subscription;

    // Fluxo quando tiver uma inscrição
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(5);
    }

    // Fluxo quando tiver um próximo elemento
    @Override
    public void onNext(Integer item) {
        logger.info("Receiving " + item);
        this.subscription.request(1);
    }

    // Fluxo de erros
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    // Fluxo de operação completa
    @Override
    public void onComplete() {
        logger.info("Done!");
    }

}

public class ReactiveWithFlow {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        CustomSubscriber subscriber = new CustomSubscriber();

        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
            publisher.subscribe(subscriber);

            IntStream
                    .range(1, 10)
                    .forEach(i -> {
                        LOGGER.info("Emitting " + i);
                        publisher.submit(i);
                    });

            sleep();
        }
    }

    private static void sleep() {
        try {
            SECONDS.sleep(10);
        } catch (InterruptedException e) {
            LOGGER.severe(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
