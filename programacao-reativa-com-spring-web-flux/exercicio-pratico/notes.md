# Exercício prático

### Exemplo de fluxo de dados com *downstream* (tratamento de exceções)

```java
public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1, 1, SECONDS)
                .map(PrintReactiveErrorFlow::transform)
                .subscribe(
                        PrintReactiveErrorFlow::process, // método para o próximo elemento do fluxo
                        PrintReactiveErrorFlow::dealWithError // método em caso de erro (tratamento da exceção)
                );

        SECONDS.sleep(10);
    }

    private static void dealWithError(Throwable throwable) {
        throwable.printStackTrace();
    }

    private static void process(Long number) {
        System.out.println("Receive number " + number);
    }

    private static Long transform(Long number) {
        if (new Random().nextDouble() < 0.3) {
            throw new RuntimeException("Ops!");
        }

        return number * 2;
    }
```