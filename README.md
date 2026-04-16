# ESG Carbon Service

Tema: **Monitoramento de emissão de carbono e compensação ambiental automatizada**.

## Stack
- Java 17 / Spring Boot 3.3
- Spring Web, Data JPA, Validation, Security
- Oracle XE 21c (Docker) + Flyway
- Dockerfile + docker-compose

## Endpoints principais
- `GET /emissoes?companyId=&start=&end=` — lista registros de emissões
- `POST /emissoes` — cria um registro de emissão (auth: Basic `admin`/`admin123` ou `analyst`/`analyst123`, ambos funcionam para POST deste exemplo)
- `GET /empresas` — lista empresas
- `GET /compensacoes` — lista iniciativas de compensação
- `POST /compensacoes` — cria compensação (auth)
- `PUT /compensacoes/{id}` — atualiza status/endDate (auth)
- `DELETE /compensacoes/{id}` — exclui compensação (auth)
- `GET /agendamentos-reducao` — lista agendamentos
- `POST /agendamentos-reducao` — cria agendamento (auth)
- `PUT /agendamentos-reducao/{id}/status/{status}` — atualiza status (auth) — status: `PLANNED|ACTIVE|COMPLETED|CANCELLED`
- `GET /indicadores` — indicadores gerais (emissões, compensações, balanço líquido)
- `GET /impacto/{id}` — impacto estimado de uma compensação

> **Segurança:** GETs públicos. POST/PUT/DELETE exigem Basic Auth. Usuários in-memory: `admin/admin123` (ROLE_ADMIN) e `analyst/analyst123` (ROLE_ANALYST).

## Subir com Docker
1. `docker compose up -d --build`
2. Aguarde o Oracle inicializar.
3. A API sobe em `http://localhost:8080`.

## Migrações
Flyway cria as tabelas em `ESG_APP` e insere dados de exemplo (V1__init.sql).

## Coleção Postman
Importe o arquivo `postman/ESG-Carbon.postman_collection.json`.
