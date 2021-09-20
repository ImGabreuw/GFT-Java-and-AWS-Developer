# Aprenda a criar um profile de teste e a trabalhar com MockMVC

### Profile

* Habilitar um configuração apenas em determinado *profile*

  ```java
  @Component
  @Profile("test")
  public class TestConfig {}
  ```

* Habilitar um *profile*

  * Via classe Java

    ```java
    @ActiveProfiles("test")
    ```

  * Via arquivo `.yaml` ou `.properties`
  ```yaml
  ```

### MockMVC

* Indicar ao Spring como uma classe teste

  ```java
  @RunWith(SpringRunner.class)
  @WebMvcTest(SoldierController.class)
  public class SoldierControllerTest {}
  ```

  > @WebMvcTest(...): subir apenas o contexto necessário para a execução do teste (+ performático)

* Implementação do teste

  ```java
  mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/soldiers/1")
                                .header("meu_header", "")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(
                        MockMvcResultMatchers
                                .header()
                                .string("Content-Type", "application/json;charset-UTF-8")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                )
                .andExpect(
                        MockMvcResultMatchers
                                .content()
                                .json(jsonOutString)
                );
    }
  ```