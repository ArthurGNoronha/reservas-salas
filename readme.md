# Instruções para Subir os Microsserviços

Este projeto utiliza arquitetura de microsserviços com Docker Compose para orquestração dos containers. Os principais serviços são: Usuários, Reservas, Salas, Gateway, Eureka Server e Adminer.

---

## Índice

- [Pré-requisitos](#pré-requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Passo a Passo](#passo-a-passo)
- [Endpoints dos Microsserviços](#endpoints-dos-microsserviços)
- [Comandos Úteis](#comandos-úteis)
- [Observações](#observações)
- [Contato](#contato)

---

## Pré-requisitos

Certifique-se de que as seguintes ferramentas estejam instaladas no seu ambiente:

- [Docker](https://www.docker.com/get-started)
- Git (opcional, para clonar o repositório)

Além disso, as seguintes portas devem estar **liberadas** no seu host:

- `8090` (Gateway)
- `8081` (Adminer)
- `8082` (Reservas)
- `8083` (Salas)
- `8085` (Usuários)
- `8761` (Eureka Server)
- `5432` (Banco de dados Reservas)
- `5433` (Banco de dados Usuários)
- `5434` (Banco de dados Salas)
- `5672`, `15672` (RabbitMQ)

---

## Estrutura do Projeto

```
reservas-salas/
│
├── docker-compose.yml
├── readme.md
├── eurekaServer/
├── gatewayApplication/
├── reservasApplication/
├── salaApplication/
├── userApplication/
└── .idea/
```

- **eurekaServer/**: Serviço de descoberta
- **gatewayApplication/**: API Gateway para roteamento das requisições
- **reservasApplication/**: Microsserviço de Reservas
- **salaApplication/**: Microsserviço de Salas
- **userApplication/**: Microsserviço de Usuários
- **.idea/**: Configurações do projeto (IDE)

---

## Passo a Passo

1. **Clone o repositório (se necessário):**
   ```bash
   git clone https://github.com/ArthurGNoronha/reservas-salas
   cd reservas-salas
   ```

2. **Suba os microsserviços com Docker Compose:**
   ```bash
   docker compose up -d --build
   ```

   Isso irá construir as imagens (caso necessário) e iniciar todos os containers em modo destacado.

3. **Acompanhe os logs (opcional):**
   ```bash
   docker compose logs -f
   ```

---

## Endpoints dos Microsserviços

**Certifique-se que o gateway e os microsserviços aparecem no eureka antes de tentar acessar.**

Após a inicialização, os microsserviços estarão disponíveis nos seguintes endereços:

- [`http://localhost:8085/usuarios/front`](http://localhost:8085/usuarios/front) → **Usuários**
- [`http://localhost:8082/reservas/front`](http://localhost:8082/reservas/front) → **Reservas**
- [`http://localhost:8083/salas/front`](http://localhost:8083/salas/front) → **Salas**
- [`http://localhost:8090/(salas/reservas/usuarios)/front`](http://localhost:8090/reservas/front) → **Gateway**
- [`http://localhost:8761`](http://localhost:8761) → **Eureka Server**
- [`http://localhost:8081`](http://localhost:8081) → **Adminer** (interface web para bancos de dados)
- [`http://localhost:15672`](http://localhost:15672) → **RabbitMQ Management** (usuário: guest, senha: guest)

---

## Comandos Úteis

- **Parar todos os containers:**
  ```bash
  docker compose down
  ```

- **Parar e remover todas as imagens criadas:**
  ```bash
  docker compose down --rmi all
  ```

- **Parar e remover uma imagem específica:**
  ```bash
  docker compose down && docker rmi <ID_DA_IMAGEM>
  ```

- **Reconstruir um serviço específico:**
  ```bash
  docker compose up -d --build <nome_do_serviço>
  ```

---

## Observações

- Certifique-se de que nenhuma das portas necessárias esteja sendo utilizada por outros serviços.
- O Adminer pode ser utilizado para acessar os bancos de dados PostgreSQL de cada microsserviço.
- O Eureka Server pode ser acessado em [`http://localhost:8761`](http://localhost:8761) para visualizar os microsserviços registrados (Ele pode demorar um pouco para encontrar).
- O Gateway centraliza as requisições e faz o roteamento para os microsserviços corretos.
- O RabbitMQ Management pode ser acessado em [`http://localhost:15672`](http://localhost:15672) com usuário e senha `guest`.

---

- Autor: Arthur Noronha
