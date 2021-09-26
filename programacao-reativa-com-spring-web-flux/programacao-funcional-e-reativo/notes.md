# Programação funcional x reativo

### Programação funcional

* Composição de funções

* Avaliação tardia (Lazy Evaluation)

* Stream VS Reactive Streams

  Streams | Reactive Streams
  :-----: | :--------------:
  pipeline | pipeline
  lazy evaluation | lazy evaluation
  push | push
  contêm apenas dados | contêm não apenas dados
  não lida com exceções | tratamento de exceções com *downstream*
  fluxo único de dados | múltiplos fluxos de dados (subscribers)
  leitura sequencial dos dados | leitura *backpressure* dos dados
