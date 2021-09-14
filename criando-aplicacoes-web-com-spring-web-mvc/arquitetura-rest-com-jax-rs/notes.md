# Arquitetura REST com JAX-RS

### Extraindo valores

* `@PathVariable`

  * **Função**: especificar quer o valor do parâmetro será indicado na URI

  * **Exemplo**: `meusite.com.br/usuario/{id}`

* `RequestParam`

  * **Função**: extrair o valor do parâmetro da URI

  * **Exemplo**: `meusite.com.br/usuario?idade=10&uf=RS`

* `@RequestBody`

  * **Função**: receber os valores no corpo da requisição

### Response

* `ResponseEntity`: representa toda a resposta HTTP. É possível controlar o código de status, cabeçalho e corpo da resposta