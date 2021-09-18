# Conheça a biblioteca client nativo

### Java HTTP client (nativo)

* **Desvantagem**: muito verboso

* **Alguns métodos básico**

  * `send(HttpRequest request, HttpResponse.BodyHandlers response)`

    * **Função**: enviar um requisição

  * `HttpRequest.newBuilder()`

    * **Função**: *builder* para facilitar a construção de uma *request*

    * **Exemplo**

      ```java
      HttpRequest.newBuilder()
          .uri(...)
          .header(...)
          .GET() // Verbo HTTP da requisição
      ```