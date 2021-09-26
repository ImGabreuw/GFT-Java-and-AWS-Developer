package me.gabreuw.reactive;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.schedulers.Schedulers;

import java.util.stream.IntStream;

public class Backpressure {

    public static void main(String[] args) {
        Flowable.create(
                        Backpressure::emit,
                        BackpressureStrategy.BUFFER // lentidão no processamento dos dados (dados importantes e que não podem ser perdidos), é acelerado (BUFFER) esse processo, essa estratégia é muito eficiente nesse cenário
                        // BackpressureStrategy.DROP // os dados que não são possíveis de serem processados são descartados (Caso de uso: dados irrelevantes (podem ser descartados) + necessidade de alta velocidade no processamento dos dados)
                        // BackpressureStrategy.ERROR // os dados que não são possíveis de serem processados é lançado um erro
                        // BackpressureStrategy.LATEST // em caso do processador estar com dificuldade no processamento dos dados, o último a ser produzido será aquele a ser processado
                        // BackpressureStrategy.MISSING // em caso do processador estar com dificuldade no processamento dos dados, os restantes dos dados a serem processados são eliminados e por fim é lançado uma exceção
                )
                .observeOn(Schedulers.computation(), false, 2)
                .subscribe(Backpressure::process);
    }

    private static void process(Integer number) {
        System.out.println("Processing " + number);
        sleep(1_000);
    }

    private static void emit(FlowableEmitter<Integer> emitter) {
        IntStream.rangeClosed(1, 10)
                .forEach(n -> {
                    System.out.println("Emitting " + n);
                    emitter.onNext(n);
                    sleep(500);
                });

        emitter.onComplete();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
