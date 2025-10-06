# Biblioteca Comunitária
#### Kaique Zaffarani | 556677

## Descrição

Projeto de sistema de biblioteca comunitária desenvolvido com **Spring Boot**, **MySQL** e **Thymeleaf**.
O sistema permite gerenciar **livros**, **usuários** e **empréstimos**, incluindo cadastro, edição, listagem e devolução de livros.

---

## Tecnologias Utilizadas

* **Spring Boot**: framework Java para desenvolvimento de aplicações web.
* **Spring Data JPA**: integração com banco de dados relacional.
* **MySQL**: banco de dados para persistência de dados.
* **Thymeleaf**: engine de templates para renderizar HTML dinamicamente.
* **Jakarta Validation**: validação de campos em formulários.
* **Maven**: gerenciamento de dependências do projeto.

---

## Funcionalidades

### Livros

* Listar todos os livros
* Listar livros disponíveis
* Cadastrar, editar e excluir livros
* Gerenciar status: Disponível / Emprestado

### Usuários

* Listar todos os usuários
* Cadastrar, editar e excluir usuários
* Validação de nome e email

### Empréstimos

* Registrar novo empréstimo
* Validar datas e disponibilidade de livros
* Listar todos os empréstimos
* Devolver livros e atualizar status automaticamente

---

## Estrutura do Projeto

```
src/main/java/com/fiap/cp5/
├── controller
│   ├── LivroController.java       <!-- Controla requisições de livros -->
│   ├── UsuarioController.java    <!-- Controla requisições de usuários -->
│   └── EmprestimoController.java <!-- Controla requisições de empréstimos -->
├── model
│   ├── Livro.java
│   ├── Usuario.java
│   └── Emprestimo.java
├── repository
│   ├── LivroRepository.java
│   ├── UsuarioRepository.java
│   └── EmprestimoRepository.java
└── service
    ├── LivroService.java          <!-- Contém regras de negócio de livros -->
    ├── UsuarioService.java        <!-- Contém regras de negócio de usuários -->
    └── EmprestimoService.java     <!-- Contém regras de negócio de empréstimos -->
```

---

## Configuração do Banco de Dados

1. Criar banco de dados no MySQL:

```sql
CREATE DATABASE biblioteca;
```

2. Configurar o `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## Como Executar

1. Clonar o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

2. Entrar na pasta do projeto:

```bash
cd spring-app
```

3. Executar o projeto:

```bash
mvn spring-boot:run
```

4. Abrir no navegador:

```
http://localhost:8080
```

---

## Fluxo do Sistema

1. **Controller**: recebe requisições HTTP e envia para o Service.
2. **Service**: processa regras de negócio, valida dados e chama o Repository.
3. **Repository**: realiza operações no banco de dados (CRUD).
4. **Thymeleaf**: renderiza páginas HTML dinâmicas com os dados retornados.

---

## Observações

* O status dos livros é atualizado automaticamente ao registrar ou devolver um empréstimo.
* Formulários possuem validação de campos obrigatórios e email.
* Mensagens de erro do Service são exibidas nas páginas Thymeleaf.

---

## Sugestões de Extensão

* Implementar paginação e filtros na listagem de livros e usuários.
* Adicionar autenticação de usuários e permissões.
* Relatórios de empréstimos atrasados e histórico de usuários.