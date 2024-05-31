## InteliBank
Este é um projeto da minha faculdade (OOP) em que implemento um banco simples. Está em desenvolvimento, como se pode perceber.

### Person
Classe para caracterizar todos os clientes. Que implementa um IUser, para se aproveitar do enum EUser, aonde 

### DataOperation
Classe que outras duas( transfer e Loan) herdarão desta, já que tem coneúdos praticamente idênticos. Esta classe se utiliza de um ENUM (ETransactions) para definir o tipo se é uma transferência ou um empréstimo, que futuramente poderá introduzir outros tipos.

### Loan
Esta classe é o único modo de introduzir dinheiro para o usuário, e futuramente, investimentos em crypto pode ser adicionado, mas provavelmente no projeto em C#.

### Batadase
Esta classe serve para iniciar a DB no elephantSQL e iniciar as tabelas Pessoa, Transfer, Loan. Além disso, ela ainda introduz métodos para iniciar e finalizar a conexão com a base de dados.

### SQLQueries
Esta classe existe para cumprir o modelo MVC, em que contém todos as funções de acessos na base de dados.
- SQLRegistrar -> Person
- SQLogin      -> Person
- SQLTransfer  -> void
- SQLTakeLoan  -> void
- SQLPayLoan   -> void
- SQLExtract   -> void (retornaria um arquivo de texto)
