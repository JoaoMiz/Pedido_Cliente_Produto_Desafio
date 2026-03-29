Desafio

H2 URL jdbc:h2:mem:desafiodb
USERNAME: sa
SENHA:

---------------------------------------------------------------------------------------
Estrutura de pastas 

src/main/java/xped/desafio
│
├── controller
│   ├── ClienteController.java
│   ├── ProdutoController.java
│   └── PedidoController.java
│
├── service
│   ├── ClienteService.java
│   ├── ProdutoService.java
│   └── PedidoService.java
│
├── repository
│   ├── ClienteRepository.java
│   ├── ProdutoRepository.java
│   └── PedidoRepository.java
│
├── model
│   ├── Cliente.java
│   ├── Produto.java
│   └── Pedido.java
│
└── DesafioApplication.java



A pasta model contém as classes que representam os dados da aplicação (Cliente, Produto e Pedido). É aqui que ficam as entidades mapeadas com JPA e também os relacionamentos entre elas.

A pasta repository é responsável pelo acesso ao banco de dados. As interfaces que ficam aqui utilizam o Spring Data JPA para fazer operações como salvar, buscar, listar e deletar dados.

A pasta service concentra a lógica de negócio da aplicação. Ela faz a intermediação entre o controller e o repository, tratando dados, validando informações e resolvendo regras mais específicas, como no caso do Pedido, onde é necessário buscar o cliente e os produtos antes de salvar.

A pasta controller é onde ficam os endpoints da API. Ela recebe as requisições HTTP (GET, POST, DELETE), chama os serviços necessários e retorna as respostas em formato JSON.

A classe DesafioApplication é a responsável por iniciar a aplicação Spring Boot.

