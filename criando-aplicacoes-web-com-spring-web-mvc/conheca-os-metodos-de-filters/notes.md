# Conheça os métodos de filters

### Filter

* É responsável por controlar a entrada e saída de tudo na aplicação

* É possível implementar 3 métodos 

  * `init(FileConfig filterConfig)`

    * **Função**: indicar para um filtro que ele está sendo colocado em serviço

    * **OBS**: é chamado uma única vez (ao iniciar a aplicação) pelo *container web*

  * `doFilter()`

    * **Função**: é responsável por fazer o "filtro" das requisições e respostas

    * **OBS**: é chamado pelo *container web* toda vez que for disparado um requisição ou resposta. A requisição e resposta é passado pela cadeia devido a uma solicitação do cliente por um recurso no final da cadeia (**FilterChain**)

      > FilterChain: é transmitido para o método `doFilter` que permite o Filter transmitir a solicitação e a resposta para a próxima entidade na cadeia

  * `destroy()`

    * **Função**: limpara memória / cache relacionado aos *Filters* da aplicação

    * **OBS**: é chamado apenas quando todas as threads no método `doFilter` de um *filter* tiverem saído ou após um período de tempo limite. Após a chamada desse método pelo *container web*, o método `doFilter` não será chamado novamente (apenas na instância que o `filter` foi destruído)
  