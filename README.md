# 📚 **Aluno Online**

API desenvolvida em Java para gestão acadêmica, otimizando o gerenciamento de  alunos, professores, disciplinas e matrículas. Uma solução para automatizar a gestão de processos acadêmicos. 

---

## 📂 **Arquitetura de Pastas**

- **`config`**
  
  - *Configurações principais da API*:
    
  - `SwaggerConfig`: Configura o Swagger para gerar a documentação interatica da API, exibindo os endpoints e suas descrições.

- **`controller`** -> Que tem como objetivo definir as rotas da aplicação (endpoints da API) e verifica as requisições do cliente.
  
  - *Gerenciamento de rotas e endpoints*:
    
  - `AlunoController`: Gerencia as operações relacionadas aos alunos como o cadastro, consulta atualização e remoção dos mesmos. 
  - `DisciplinaController`: Faz o gerenciamento das disciplinas, como as informações de nome descrição entre outros.  
  - `MatriculaAlunoController`: Faz o gerenciamento do vínculo de alunos com as disciplinas que estão atreladas as matrículas.  
  - `ProfessorController`: Controla o gerenciamneto dos professores e as informações que cada um deles tem.

- **`dtos`** -> Tem como objetivo fazer a transferencia de dados de uma forma mais efeiciente entre as camadas do sistema, ajudando a facilitar os dados enviados ou recebidos pela API.
  
  -  *Transferência de dados*:
    
  - `AtualizarNotasRequest`: Usada para enviar os dados necessários para atualizar as notas de um aluno específico (ID).  
  - `DisciplinasAlunoResponse`: Estrutura para resposta que retorna as informações sobre disciplinas que estão associadas a um aluno específico.  
  - `HistoricoAlunoResponse`: Resposta com o histórico academico de um aluno específico e as informações do mesmo.

- **`enums`**  -> Contem os valores fixos, como nesse caso é o status da matrícula para o uso no sistema.
  
  -  *Valores fixos e estados*:
    
  - `MatriculaAlunoStatusEnum`: Menciona os possíveis status da matrícula como MATRICULADO, APROVADO, REPROVADO OU TRANCADO.

- **`model`**  -> Representação das entidades principais do sistema que auxiliam no mapeamento das tabelas com o banco de dados.
  
  -  *Entidades do sistema*: São as classes presentes em nosso projeto.
    
     - `Aluno`, `Disciplina`, `MatriculaAluno`, `Professor`.

- **`repository`** -> Auxiliando na interação da interface com o BD.
  
  - *Acesso ao banco de dados*:
    
  - `AlunoRepository`, `DisciplinaRepository`, `MatriculaAlunoRepository`, `ProfessorRepository`.

- **`service`** -> Serve para implementar as regras de negócio, para processar os dados antes de enviar ou receber do banco de dados.
  
  - *Regras de negócio*:
    
  - `AlunoService`, `DisciplinaService`, `MatriculaAlunoService`, `ProfessorService`.

---

## Organização do Código

Para garantir uma arquitetura modular e de fácil manutenção, adotamos o padrão Model-View-Controller (MVC). Essa escolha permite uma clara separação de responsabilidades entre a camada de apresentação (views), a lógica de negócio (controllers) e o modelo de dados (models), resultando em um código mais limpo, escalável e testável.

---

## 🚀 **Tecnologias Utilizadas**

[![habilidades](https://skillicons.dev/icons?i=java,mysql,idea,spring)](skillicons.dev)

---


## 🛠 Ferramentas Utilizadas

- **Insomnia**: Utilizado para testar os endpoints e validar o funcionamento do sistema via requisições HTTP. Ferramenta essencial para verificar as respostas e simular interações com a API.
- **DBeaver**: Gerenciador de Banco de Dados utilizado para interagir com o PostgreSQL, permitindo consulta e manipulação eficiente dos dados armazenados no SGBD.
- **IntelliJ IDEA**: IDE principal utilizada para o desenvolvimento do projeto. Oferece suporte avançado para Java, integração com bibliotecas, debugging eficiente e ferramentas para gerenciamento de dependências.
  
--- 

## 📋 Endpoints Disponíveis

Abaixo temos a lista detalhada de endpoints com os métodos HTTP disponíveis neste projeto:

### 📂 MatriculaAluno
| Método | Endpoint             | Descrição                          |
|--------|----------------------|------------------------------------|
| `GET`  | `/matricula/historico` | Retorna o histórico do aluno.       |
| `PATCH`| `/matricula/notas`     | Atualiza as notas do aluno.         |
| `PATCH`| `/matricula/trancar`   | Tranca a matrícula de um aluno.     |
| `POST` | `/matricula`           | Cria uma nova matrícula.            |

### 📂 Disciplina
| Método | Endpoint                     | Descrição                          |
|--------|------------------------------|------------------------------------|
| `GET`  | `/disciplinas/professor/{id}` | Lista disciplinas de um professor. |
| `PUT`  | `/disciplinas/{id}`           | Atualiza uma disciplina por ID.    |
| `DELETE`| `/disciplinas/{id}`          | Deleta uma disciplina por ID.      |
| `GET`  | `/disciplinas`                | Lista todas as disciplinas.        |
| `GET`  | `/disciplinas/{id}`           | Busca disciplina por ID.           |
| `POST` | `/disciplinas`                | Cria uma nova disciplina.          |

### 📂 Professor
| Método | Endpoint                   | Descrição                          |
|--------|----------------------------|------------------------------------|
| `PUT`  | `/professores/{id}`        | Atualiza um professor por ID.      |
| `DELETE`| `/professores/{id}`       | Deleta um professor por ID.        |
| `GET`  | `/professores`             | Lista todos os professores.        |
| `GET`  | `/professores/{id}`        | Busca um professor por ID.         |
| `POST` | `/professores`             | Cria um novo professor.            |

### 📂 Aluno
| Método | Endpoint                   | Descrição                          |
|--------|----------------------------|------------------------------------|
| `PUT`  | `/alunos/{id}`        | Atualiza um aluno por ID.               |
| `DELETE`| `/alunos/{id}`       | Deleta um aluno por ID.                 |
| `GET`  | `/alunos`             | Lista todos os alunos.                  |
| `GET`  | `/alunos/{id}`        | Busca um aluno por ID.                  |
| `POST` | `/alunos`             | Cria um novo aluno.                     |

---


