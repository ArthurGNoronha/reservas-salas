# Instruções para Subir os Microsserviços

## Pré-requisitos

Certifique-se de que as seguintes portas estejam **liberadas** no seu host:

- `8080`
- `8081`
- `8082`
- `8083`
- `8085`
- `5432`
- `5433`
- `5434`

## Passo a Passo

1. Navegue até a pasta `reservas-salas` no terminal:
   ```bash
   cd reservas-salas
   ```

2. Execute o comando abaixo para subir os microsserviços com Docker Compose:
   ```bash
   docker compose up -d --build
   ```

## Endpoints dos Microsserviços

Se tudo estiver funcionando corretamente, os microsserviços estarão disponíveis nos seguintes endereços:

- [`localhost:8085/usuarios`](http://localhost:8085/usuarios) → **Usuários**
- [`localhost:8082/reservas`](http://localhost:8082/reservas) → **Reservas**
- [`localhost:8083/salas`](http://localhost:8083/salas) → **Salas**
- [`localhost:8081`](http://localhost:8081) → **Adminer**

3. Para parar os container utilize:
   ```bash
   docker compose down
   ```
   
   ou

   ```bash
   docker compose down --rmi all
   ```