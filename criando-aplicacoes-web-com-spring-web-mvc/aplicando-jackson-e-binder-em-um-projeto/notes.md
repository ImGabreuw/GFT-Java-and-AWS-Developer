# Aplicando Jackson e Binder em um projeto

### Jackson

* **Função**: responsável por efetuar a serialização e de objetos

* Algumas anotações

  * `@JsonProperty`: indicar um nome customizado de uma propriedade que será mapeado

    * **Exemplo**

      ```java
      public class MinhaClasse {

        @JsonProperty("id")
        private Long meuId;

      }
      ```

      ```json
      {
        "id": 1
      }
      ```

      > Entre parênteses, indicar o nome da propriedade que será exibido no JSON

  * `@JsonFormat`: formatar datas

    * **Exemplo**

      ```java
      @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
      ```

  * `@JsonIgnore`: ignorar um atributo a ser mapeado

    * **Exemplo**

      ```java
      public class MinhaClasse {

        private Long id;

        @JsonIgnore
        private String atributoIgnorado;

      }
      ```

      ```json
      {
        "id": 1
      }
      ```

  * `@JsonGetter`: tem a mesma função do `@JsonProperty`, porém se aplica aos métodos *getters*

    * **Exemplo**

       ```java
      public class MinhaClasse {

        private Long id;

        @JsonGetter("id")
        public Long getMeuId() {
          return id;
        }
      }
      ```

      > Entre parênteses, indicar o nome do atributo que esse método *getter*, customizado, se refere

  * `@JsonSetter`: tem a mesma função do `@JsonProperty`, porém se aplica aos métodos *setters*

    * **Exemplo**

       ```java
      public class MinhaClasse {

        private Long id;

        @JsonSetter("id")
        public void setMeuId(Long id) {
          this.id = id;
        }
      }
      ```

      > Entre parênteses, indicar o nome do atributo que esse método *setter*, customizado, se refere

* **ObjectMapper**
  * **Função**: responsável pelo mapeamento dos objetos Java para JSON e vice-versa


* **Custom Data Binder**

  * **Função**: criar um *mapper* de uma propriedade no qual não é reconhecido por padrão

  * **Exemplo**

    ```java
    enum
    ```

    > Os `enum`s associados a um objeto não são possíveis de serem serializados, a partir do mapper implementado, por padrão, pelo Jackson