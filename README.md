# Projeto Programa milhas

<p>Projeto entregue durante o curso de desenvolvimento Web ministrado pela <a href="https://www.betrybe.com" targe="_blank" rel="nofollow">Trybe</a>.</p>

<p>Obtive a aprovação no projeto completando 100% dos requisitos obrigatórios e opcionais. Efetivando, assim, a conclusão do Bloco 12 (Quarkus) referente a Aceleração em Java.</p>

## Descrição
  Programa de fidelidade, nos moldes de um programa de milhagem. Clientes da empresa podem receber milhas, transferir para outra pessoa ou resgatar em algum produto ou serviço.


### 🟧 Tabelas
O sistema possui cinco tabelas:
- Pessoa
- Lancamento
- TipoLancamento
- Produto
- Parceiro

> Essas tabelas estão disponíveis em um banco H2 em memória que sobe junto com a aplicação. Caso queira conferir a criação e os dados iniciais de cada tabela, veja o arquivo `cargainicial.sql`, dentro da pasta de resources. Os domínios "TipoLancamento", "Produto" e "Parceiro" já estão com seus dados cadastrados. 

Para facilitar os testes e o uso, o sistema inicia com duas pessoas e um lançamento de crédito de 10 mil milhas para cada uma:

- Login huguinho / Senha: root
- Login zezinho / Senha: senha

*O sistema foi recebido em um estágio mediano de desenvolvimento, e a tarefa foi implementar as funcionalidades necessárias para que todos os testes passassem.*

### 🟩  Requisitos propostos para o desenvolvimento do projeto

 - Tentativa de acessar endpoints fechados com o token ausente ou inválido devem resultar em erro 500 com a mensagem `Acesso não autorizado.`
 - Tentativa de login com qualquer informação incorreta deve resultar em erro 500 com a mensagem `Autenticacão inválida.`
 - Tentativa de retirada em conta com saldo inferior ao da retirada deve resultar em erro 500 com a mensagem `Saldo insuficiente.`
 - Lançamentos podem possuir valores **positivos** ou **negativos** na base de dados, mas na nossa API sempre vão chegar **positivos**. Tome cuidado com retiradas e transferências!
 - O arquivo `openapi-programa-milhas.txt` na raiz do projeto é a especificação Open API completa para o sistema.

## Rodando o projeto localmente
  1. Clone o repositório
   
     `git@github.com:Lucas-PCN/programa-milhas.git`
    
  2. Entre no diretório do repositório que você acabou de clonar:
  
     `cd programa-milhas`

  3. Instale as dependências:
    
     `mvn install`

---

Projeto desenvolvido por Lucas Castanheira, para fins didáticos. 2023
