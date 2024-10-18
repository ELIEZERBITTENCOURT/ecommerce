# Project E-commerce Springboot

Este é um projeto básico de API para um sistema de e-commerce desenvolvido com **Spring Boot**. O sistema permite o gerenciamento de produtos, carrinho de compras, e a integração com o **Stripe** para simulação de transações de pagamento.

## Funcionalidades

- **Catálogo de Produtos**: CRUD básico para gerenciamento de produtos.
- **Carrinho de Compras**: Adicionar, remover e visualizar itens no carrinho.
- **Sistema de Pagamento**: Integração com a API do Stripe para simulação de pagamentos.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada.
- **Spring Boot**: Framework principal para desenvolvimento da API.
- **Spring Data JPA**: Para persistência e gerenciamento de dados no banco MySQL.
- **Stripe API**: Integração com a plataforma de pagamentos.
- **MySQL**: Banco de dados relacional utilizado.

## Pré-requisitos

- **Java 21** ou superior
- **Maven** para gerenciamento de dependências
- **MySQL** para o banco de dados
- **Conta Stripe** para testar a integração de pagamentos (utilizando chave de teste)

### Configurações Necessárias

1. Configure o banco de dados no arquivo `application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

2. Configure a chave de API do Stripe no arquivo `application.properties`:

    ```properties
    stripe.api.key=sk_test_sua_chave_API
    ```

## Endpoints

### Produtos

- **GET /api/produtos**: Retorna todos os produtos.
- **POST /api/produtos**: Adiciona um novo produto.
- **PUT /api/produtos/{id}**: Atualiza um produto existente.
- **DELETE /api/produtos/{id}**: Remove um produto.

### Carrinho

- **POST /api/carrinho/adicionar**: Adiciona um item ao carrinho.
- **POST /api/carrinho/remover**: Remove um item do carrinho.
- **GET /api/carrinho**: Exibe o conteúdo do carrinho.

### Pagamentos

- **POST /api/pagamentos/iniciar?valor={valor}**: Inicia um pagamento com o valor especificado.
- **POST /api/pagamentos/confirmar/{paymentIntentId}**: Confirma um pagamento.
