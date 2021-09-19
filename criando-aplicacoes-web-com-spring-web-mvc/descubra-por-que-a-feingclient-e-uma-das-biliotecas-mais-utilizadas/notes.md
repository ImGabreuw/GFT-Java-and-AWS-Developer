# Descubra por que a Feign Client é uma das bibliotecas mais usadas

### Feign Client 

* **Material de apoio**

  * https://www.baeldung.com/spring-cloud-openfeign

* **Vantagens**

  * Simple de se utilizar

  * Versátil

* **Configuração do Feign Client no Spring**

  * **Dependências**

    * **Maven**

      ```xml
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-openfeign</artifactId>
      </dependency>
      ```
    
    * **Gradle**

      ```gradle
      implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
      ```

  * Anotar a classe principal com `@EnableFeignClient`

    ```java
    @SpringBootApplication
    @EnableFeignClient
    public class DemoApplication {
        
      public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
      }

    }
    ```

  * Criar um classe de configuração e anotá-la com `@EnableFeignClient`

    ```java
    @Configuration
    @EnableFeignClient
    public class FeignClientConfig {}
    ```

* **Sintaxe**

  ```java
  @FeignClient(url = "www.google.com", name = "google")
  public interface FeignClient {}
  ```

* **Algumas anotações**

  * `@GetMapping`

    * **Exemplo**

      ```java
      @GetMapping("/users")
      ```

  * `@PostMapping`

    * **Exemplo**

      ```java
      @PostMapping("/users/create")
      ```

  * `@PutMapping`

    * **Exemplo**

      ```java
      @PutMapping("/users/update")
      ```

  * `@DeleteMapping`

    * **Exemplo**

      ```java
      @DeleteMapping("/users/delete")
      ```
  
  * `@RequestMapping`

    * **Exemplo**

      ```java
      @RequestMapping(method = RequestMethod.GET, value = "/users")
      ```

  * `@RequestBody`
  
    * **Função**: adicionar um corpo na requisição

    * **Exemplo**

      ```java
      @PostMapping("/users/create")
      UserResponse create(@RequestBody UserRequest user);
      ```

  * `@ResponseBody`: retornar apenas o corpo da resposta

  * `@PathVariable`
  
    * **Função**: adicionar uma variável na url da requisição

    * **Exemplo**

      ```java
      @GetMapping("/users/{id}")
      UserResponse findById(@PathVariable("id") Long id);
      ```

  * `@Param` 
  
    * **Função**: adicionar um parâmetro na url da requisição

    * **Exemplo**:

      ```java
      @GetMapping("/users")
      ResponseEntity<UserResponse> findAll(@Param("sort") String sort);
      ```

  * `@RequestHeader`

    * **Função**: adicionar um *header* na requisição

    * **Sintaxe**

      ```java
      @RequestHeader("MEU_HEADER: MEU_VALOR")
      ```
  * `@Headers`
  
    * **Função**: adicionar 1 ou mais header(s) na requisição

    * **Exemplo**
    
      ```java
      @Headers("MEU_HEADER: [meu_header]")
      @GetMapping("/users")
      ResponseEntity<UserResponse> findAll(@Param("meu_header") String header);
      ``` 

      > `[meu_header]`: indicar que "meu_header" é um nome de um parâmetro (nome entre colchetes)

* **OBS**

  * Por padrão, o Feign Client retorna uma `ResponseEntity<?>` nos métodos definidos para cada requisição