# Entendendo o Spring Web MVC

### Spring Framework

* Complemento ao *Java EE* (Java Enterprise Edition)

* É um container de Inversão de Controle (IoC)

  > IoC = Inversion of Controler

* Permite a utilização do padrão de projeto **Injeção de dependência** (DI), com a anotação `@Autowired`

  > DI = Dependency Injection

* **Spring Bean**: `@Bean` tem a função de tornar um objeto gerenciado pelo IoC Container

* **IoC Container**: `ApplicationContext`, do pacote `org.springframework.context` é a representação do IoC Container e é responsável por instanciar, configurar e construir os *beans*

* Spring Aspect oriented programing (AOP): [docs](https://docs.spring.io/spring-framework/docs/2.5.x/reference/aop.html)

* **Spring Web MVC**

  * Baseado no padrão arquitetural MVC (Model, View e Controller)

    * Model = camada que gerencia as regras de negócio e entidades do banco de dados

    * View = camada responsável pela interação com o usuário

    * Controller = camada intermediário entre Model e View e tem o papel de receber as requisições do usuário e enviar para o Model e assim processá-la e então enviar um resposta ao usuário

* **Spring WebFlux** (introduzido na versão 5.0 do Spring)

  * http://www.reactive-streams.org - SPEC (https://github.com/reactive-streams/reactive-streams-jvm)
  * http://projectreactor.io - IMPL (Reactor is a Reactive Streams library)
  * http://reactivex.io - IMPL (https://github.com/ReactiveX/RxJava)

* **Referências**

  * https://spring.io/projects/spring-framework#learn

  * https://docs.spring.io/spring/docs/current/spring-framework-reference/overview.html

  * https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html

### Spring Boot

* Convenção sobre configuração

* Auto configuração, por padrão

* Não é um "gerador de código"

* *Plug-and-play* de module starters

* Containers de servlet (servidor web) embarcados, como: Tomcat, Jeffy ou Underflow