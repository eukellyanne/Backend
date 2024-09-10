## Aluno Online 
### Primeira Entrega do projeto relacionado a cadeira Tecnologia para BackEnd

Dei inicio ao projeto Aluno Online para a cadeira tecnologia para BackEnd. Nas configurações iniciais do projeto utilizei o Spring Initializr para iniciar um novo projeto Spring Boot, adicionando as seguintes dependências: Spring Web, Spring Data JPA e o MySQL Driver.
- Iniciei a modelagem criando uma classe Java para representar um aluno, definindo seus atributos de acordo com sua caracterização.
- Logo após foram criados o AlunoRepository (interface para definir metódos CRUD), AlunoController (controlador para definir um endpoint Post) e AlunoService (classe de serviço para encapsular a lógica de negócio relacionada aos alunos).
- Para a criação do banco de dados usei o DBeaver e denominei alunos_online_em_sala. E dentro do banco, criei uma tabela chamada aluno para armazenar as informações dos alunos.
- Para fins de teste e de indicação do professor, usei a  ferramenta Insomnia para enviar requisições POST para o endpoint criado e verificar se os alunos estão sendo salvos corretamente no banco de dados.

#### Segue abaixo os anexos solicitados

![Captura de tela 2024-09-10 113040](https://github.com/user-attachments/assets/e45ec7c7-1627-4181-bfa6-eb7a56ed0099)

![Captura de tela 2024-09-10 112854](https://github.com/user-attachments/assets/f5add24d-532e-4d66-97b1-2da5ee44a911)
