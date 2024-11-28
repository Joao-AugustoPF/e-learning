# **E-learning API**

Bem-vindo à **E-learning API**, uma aplicação RESTful construída com **Spring Boot**. Este sistema gerencia cursos, usuários e matrículas, suportando integração com **Apache Kafka** e documentação automatizada com **Swagger**.

## **Sumário**
- [Recursos Principais](#recursos-principais)
- [Rotas da API](#rotas-da-api)
    - [Cursos](#cursos)
    - [Usuários](#usuários)
    - [Matrículas](#matrículas)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Documentação com Swagger](#documentação-com-swagger)

---

## **Recursos Principais**

- Gerenciamento de **cursos**: criação, listagem, atualização e exclusão.
- Gerenciamento de **usuários**: registro, atualização e exclusão.
- Sistema de **matrículas**: matricular usuários em cursos e rastrear progresso.
- **Mensageria** com Apache Kafka para publicação e consumo de eventos.
- Autenticação básica com Spring Security.
- Configuração modular para diferentes ambientes (`dev`, `prod`).

---

## **Rotas da API**

### **Cursos**

| Método | Endpoint            | Descrição                              | Payload/Parâmetro                         |
|--------|---------------------|----------------------------------------|-------------------------------------------|
| `GET`  | `/api/courses`      | Retorna todos os cursos               | -                                         |
| `GET`  | `/api/courses/{id}` | Retorna um curso específico pelo ID   | `id` (Long)                               |
| `POST` | `/api/courses`      | Cria um novo curso                    | `{ "name": "...", "description": "...", "instructor": "...", "price": 99.99 }` |
| `PUT`  | `/api/courses/{id}` | Atualiza um curso pelo ID             | `id` (Long), JSON com dados do curso      |
| `DELETE` | `/api/courses/{id}` | Remove um curso pelo ID              | `id` (Long)                               |

---

### **Usuários**

| Método | Endpoint            | Descrição                              | Payload/Parâmetro                         |
|--------|---------------------|----------------------------------------|-------------------------------------------|
| `GET`  | `/api/users`        | Retorna todos os usuários             | -                                         |
| `GET`  | `/api/users/{id}`   | Retorna um usuário específico pelo ID | `id` (Long)                               |
| `POST` | `/api/users`        | Cria um novo usuário                  | `{ "name": "...", "email": "...", "password": "...", "role": "STUDENT/INSTRUCTOR" }` |
| `PUT`  | `/api/users/{id}`   | Atualiza um usuário pelo ID           | `id` (Long), JSON com dados do usuário    |
| `DELETE` | `/api/users/{id}` | Remove um usuário pelo ID             | `id` (Long)                               |

---

### **Matrículas**

| Método | Endpoint                        | Descrição                                           | Payload/Parâmetro                         |
|--------|---------------------------------|---------------------------------------------------|-------------------------------------------|
| `POST` | `/api/enrollments`              | Matricula um usuário em um curso                 | `{ "userId": 1, "courseId": 2 }`          |
| `GET`  | `/api/enrollments/user/{userId}` | Retorna todas as matrículas de um usuário        | `userId` (Long)                           |
| `GET`  | `/api/enrollments/course/{courseId}` | Retorna todas as matrículas de um curso       | `courseId` (Long)                         |
| `PUT`  | `/api/enrollments/{enrollmentId}/complete` | Marca a matrícula como concluída      | `enrollmentId` (Long)                     |

---

## **Configuração do Ambiente**

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/e-learning-api.git
   cd e-learning-api
   ```

2. **Configuração do Banco de Dados**:
    - Certifique-se de que o PostgreSQL está rodando.
    - Configure o arquivo `application.properties` com as credenciais do banco:

      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/elearning
      spring.datasource.username=seu_usuario
      spring.datasource.password=sua_senha
      ```

3. **Iniciar o Projeto**:
    - Compile e execute a aplicação:
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```

4. **Testar a API**:
    - Acesse no navegador:
      ```bash
      http://localhost:8080/api/courses
      ```

---

## **Documentação com Swagger**

A API inclui uma interface Swagger para visualização e teste de endpoints. Acesse-a em:

```plaintext
http://localhost:8080/swagger-ui.html
```

---

### **Licença**

Este projeto está sob a licença [MIT](LICENSE).

---