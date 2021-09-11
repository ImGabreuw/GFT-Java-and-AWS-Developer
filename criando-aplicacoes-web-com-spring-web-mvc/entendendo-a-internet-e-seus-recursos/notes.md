# Entendendo a internet e seus recursos

### Protocolo HTTP

> HTTP Protocol = Hypertext Transfer Protocol (Protocolo de Transferência de Hipertexto)

* **Definição**: é um protocolo de comunicação utilizado para sistemas de informação de hipermídia, distribuídos e colaborativos.

* **OBS**: é a base para a comunicação de dados da Internet

* *Request* (requisição)

  `GET /hello HTTP/1.1`

  * `GET` = método HTTP

  * `/hello` = caminho

  * `HTTP/1.1` = versão do HTTP

* *Response* (resposta)

  ```
  HTTP/1.1      200 OK

  Hello, World!
  ```

  * `HTTP/1.1` = versão do HTTP

  * `200 OK` = código de status HTTP

  * `Hello, World!` = corpo da resposta HTTP

* *Http methods* (métodos/verbos HTTP)

  * `GET` = solicitar uma representação de um recurso específico

  * `POST` = submeter um novo recurso

  * `PUT` = substituir todas as representações de um determinado recurso

  * `DELETE` = remover um recurso específico

  * `PATCH` = aplicar modificações parciais em um recurso

  * Existem também os verbos: `TRACE`, `HEAD`, `OPTIONS`, `CONNECT`

### REST

> REST = Representational State Transfer (Transferência de Estado Representacional)

* **Definição**: é um **estilo arquitetural** (NÃO é um protocolo) que define um conjunto de restrições e propriedades baseados no protocolo HTTP

* **OBS**: é uma das formas mais usadas para integrações de sistemas modernos. (utiliza verbos, código, cabeçalhos e URIs para compor uma API web)

* **Recursos**: são representações dos modelos e/ou coleções de modelos que serão expostos aos clientes

* **Payload**
  * É o conteúdo das requisições e repostas 
  
  * Também pode ser chamado de *body* (corpo)

  * Contêm a localização/representação do recurso no protocolo HTTP

* **JSON VS XML**

  * São formas de representação de recursos

  * **Exemplos**

    * **JSON**

      ```json
      {
        "id": 1,
        "name": "Han Solo"
      }
      ```

    * **XML**

      ```xml
      <character>
          <id>1</id>
          <name>Han Solo</name>
      </character>
      ```

* **Header**

  * Também chamado de cabeçalho

  * Permitir a troca de informações adicionais entre requisições e resposta (cliente e servidor)

  * **Exemplo**

    Accept | Content negotiation | Accept: application/json
    :----: | :-----------------: | :----------------------:
    Cache-Control | Caching | `Cache-Control: max-age=100`
    Authorization | Authentication | `Authorization: Bearer $2b$10$yl9rJOApdaipTptRB.foFOe.6Pj2Y22LtIs8.Ispa/dxAVSPWSab6`

* **Boas práticas**

  * Sempre utilizar substantivos

    * `/getAllCars` ❌

    * `/createNewCar` ❌

    * `/deleteAllRedCars` ❌

  * NUNCA alterar o estado de um recurso com GET

    * **Exemplos**

      * `GET /users/2/activate` ❌

      * `GET /users/2/enable` ❌

  * Usar plural

    * **Exemplos**

      * `/cars`✅

      * `car` ❌

  * Usar sub-recursos para relacionamento entre recursos

    * **Exemplo**

      * `GET /books/33/pages`

  * Todo sub-recurso é um recurso em potencial (depende do negócio)

    * **Exemplos**

      * `GET /states/10/cities` ("cities" como **sub-recurso** de "states")

      * `GET /cities?region=north` ('cities' como **recurso isolado** do "states")

  * Paginação, filtros e ordenação

    * **Exemplos**

      * `GET /regions?page=0&size=1&sort=name,desc`

        * `page=0`(número da página) = paginação

        * `size=1` (número de registros por página) = paginação

        * `sort=name,desc` = ordenação

      * `GET /cities?page=0&size=10&sort=name,asc&state_id=5`

        * `page=0`(número da página) = paginação

        * `size=10` (número de registros por página) = paginação

        * `sort=name,desc` = ordenação

        * `state_id=5` = filtro

  * Versionamento da API (não quebrar o contrato da API)

    * **Exemplo**

      * Versionamento por *Header* (+ comum): `curl -X GET /cities -H "accept: application/vnd.brazil.api-v1.0+json"`

      * Versionamento por *Path*: `curl -X GET /v1/cities`

      * Versionamento via parâmetro: `curl -X GET /cities?api_version=1.0.0`

  * Sempre escolher o  *HTTP Status Code* corretamente

  * Entender o domínio em questão afim de representar a API da melhor forma

  * Documentar a API 