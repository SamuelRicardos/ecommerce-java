# 🛠️ E-commerce API - Spring Boot + MongoDB

Este é o back-end da aplicação E-commerce desenvolvida com **Java 17**, **Spring Boot** e **MongoDB**. Ele fornece uma **API RESTful** para cadastro, listagem, atualização e remoção de produtos.

Esta API foi desenvolvida para ser consumida pelo front-end em Angular 17. Link para o front-end: https://github.com/SamuelRicardos/ecommerce-angular

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3+
- Spring Data MongoDB
- MongoDB
- Maven
- Lombok (opcional)
- CORS habilitado para o front-end (http://localhost:4200)

---

## ✅ Funcionalidades da API

| Método | Endpoint           | Descrição                      |
|--------|--------------------|-------------------------------|
| GET    | `/produtos`        | Lista todos os produtos       |
| GET    | `/produtos/{id}`   | Retorna um produto por ID     |
| POST   | `/produtos`        | Cadastra um novo produto      |
| PUT    | `/produtos/{id}`   | Atualiza um produto existente |
| DELETE | `/produtos/{id}`   | Remove um produto             |

---

## 📦 Modelo de Produto (`Produtos.java`)

```java
@Document(collection = "produtos")
public class Produtos {
    @Id
    private String id;
    private String codigo;
    private String nome;
    private BigDecimal preco;
}
