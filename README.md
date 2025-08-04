# 🗄️ Demo DAO JDBC

Este projeto é uma aplicação simples desenvolvida em **Java** para demonstrar o uso do **JDBC** e do **Padrão DAO (Data Access Object)** em operações básicas de banco de dados.

---

## 🚀 Funcionalidades

- Conexão com banco de dados MySQL via JDBC
- Implementação do **DAO Pattern** para isolamento da lógica de acesso a dados
- CRUD completo para a entidade **Seller**
- CRUD em desenvolvimento para a entidade **Department**
- Boas práticas com:
  - Uso de `PreparedStatement` e `ResultSet`
  - Tratamento de exceções com `DbException`
  - Padrão **Factory** para criação de instâncias de DAO
  - Uso de `try-with-resources` para fechamento automático de conexões

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+** (compatível com versões anteriores)
- **MySQL** (banco de dados relacional)
- **JDBC** (Java Database Connectivity)
- **IDE:** Eclipse / IntelliJ IDEA

---

## 📂 Estrutura do Projeto

```
demo-dao-jdbc/
│── src/
│   ├── application/        # Classe principal para testes
│   ├── db/                 # Classe utilitária de conexão com BD
│   ├── model/
│   │   ├── entities/       # Entidades Seller e Department
│   │   ├── dao/            # Interfaces DAO
│   │   └── dao.impl/       # Implementações JDBC dos DAOs
│── db.properties           # Configurações de conexão
```

---

## ⚙️ Configuração do Banco de Dados

1. Crie um banco no MySQL:
```sql
CREATE DATABASE coursejdbc;
USE coursejdbc;
```

2. Crie as tabelas:
```sql
CREATE TABLE department (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL
);

CREATE TABLE seller (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL,
    Email VARCHAR(100),
    BirthDate DATE,
    BaseSalary DOUBLE,
    DepartmentId INT,
    FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
```

3. Configure o arquivo `db.properties` com os dados do seu MySQL:
```
user=root
password=suasenha
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/demo-dao-jdbc.git
```
2. Importe o projeto em sua IDE (Eclipse/IntelliJ).
3. Ajuste as credenciais no arquivo `db.properties`.
4. Execute a classe `Program` em `application`.

---

## 📌 Próximos Passos

- [ ] Finalizar CRUD completo para `Department`
- [ ] Implementar tratamento customizado para erros de integridade referencial
- [ ] Adicionar script SQL inicial com dados para testes

---

## 👨‍💻 Autor

- **Everton Nascimento** – [LinkedIn](https://linkedin.com)
