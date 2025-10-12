![banner](./banner.png)

# PROJETO
Projeto de sistema de biblioteca comunitária desenvolvido com Spring Boot, MySQL e Thymeleaf.
O sistema permite gerenciar livros, usuários e empréstimos, incluindo cadastro, edição, listagem e devolução de livros.

Fluxo do sistema:

- **Controller** | Recebe requisições HTTP e envia para o service.
- **Service** | Processa regras de negócio, valida dados e chama o repository.
- **Repository** | Realiza operações no banco de dados (CRUD).
- **Thymeleaf** | Renderiza páginas HTML dinâmicas com os dados retornados.

<br>

# ESTRUTURA
```
src/main/java/com/fiap/cp5/
├── controller
│   ├── LivroController.java       <!-- Controla requisições de livros -->
│   ├── UsuarioController.java     <!-- Controla requisições de usuários -->
│   └── EmprestimoController.java  <!-- Controla requisições de empréstimos -->
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

<br>

# INSTRUÇÕES
1. Em um terminal, clonar o repositório:
```bash
git clone https://github.com/Z4FFARANI-EDUCATIONAL/SEM2-CP5-DDD-JAVA
```

2. No terminal, navegar até a pasta do projeto:
```bash
cd SEM2-CP5-DDD-JAVA
```

3. No terminal, construir toda a aplicação em contêineres:
```bash
docker compose build
```

4. Abrir no navegador:
```
http://localhost:8080
```

<br>

# FUNÇÕES
`Livro.java` | `LivroRepository.java` | `LivroService.java` | `LivroController.java`:
- Criar modelo de livro.
- Persistir o modelo para o banco de dados em padrão DAO (Data Access Object).
- Listar todos os livros.
- Listar livros disponíveis.
- Gerenciar status para disponível ou emprestado.
- Cadastrar, editar, ou excluir livros.

`Usuario.java` | `UsuarioRepository.java` | `UsuarioService.java` | `UsuarioController.java`:
- Criar modelo de usuário.
- Persistir o modelo para o banco de dados em padrão DAO.
- Listar todos os usuários.
- Validação de nome e email.
- Cadastrar, editar, ou excluir usuários.

`Emprestimo.java` | `EmprestimoRepository.java` | `EmprestimoService.java` | `EmprestimoController.java`:
- Criar modelo de empréstimo.
- Persistir o modelo para o banco de dados em padrão DAO.
- Listar todos os empréstimos.
- Registrar novo empréstimo.
- Validar datas e disponibilidade de livros.
- Devolver livros, ou atualizar status automaticamente.

<br>

# OBSERVAÇÕES
- O status dos livros é atualizado automaticamente ao registrar ou devolver um empréstimo.
- Formulários possuem validação de campos obrigatórios e e-mail.
- Mensagens de erro do service são exibidas nas páginas Thymeleaf.

<br>

# TECNOLOGIAS
**[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/br/java/technologies/downloads)**
**[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://start.spring.io)**
**[![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/download.cgi)**
**[![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/downloads)**
**[![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/products/docker-desktop)**
