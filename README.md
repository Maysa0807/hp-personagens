# Harry Potter Personagens — API + Frontend  + Serviço de e-mail 

Uma aplicação completa dividida em Frontend (Angular) e Backend (Spring Boot) que se comunicam via API REST com autenticação OAuth2 + JWT integrada ao Keycloak para visualizar personagens em Cards inspirados no universo de Harry Potter. O projeto utiliza um serviço independente de e-mail (https://github.com/Maysa0807/microservices).

---

## Funcionalidades

-  API RESTful seguindo padrão de arquitetura limpa para gerenciamento dos personagens e novos usuários do site
-  Filtro de busca por nome e casa de Hogwarts
-  API de favoritos com marcação/desmarcação de personagens
-  Frontend Angular integrado ao backend
-  Estilo visual inspirado em Hogwarts (com Bootstrap e tema personalizado)
-  Cards de personagens com imagens
-  Comunicação assíncrona com serviço de envio de e-mail via RabbitMQ

---

## Tecnologias Utilizadas

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- OAuth2 + JWT
- Docker

### Frontend 
- Angular 19
- Bootstrap 
- HTML + CSS + TypeScript
- Keycloak
  
(https://github.com/Maysa0807/hp-frontend)

---
## - Diagrama mostrando o fluxo de comunicação -
<img width="1338" height="588" alt="Image" src="https://github.com/user-attachments/assets/da5b37fd-b4e1-4c9f-9f80-4c453f77a0fd" />

##  Como rodar o projeto localmente

### Pré-requisitos

- Java 21 instalado
- Node.js
- Angular CLI (`npm install -g @angular/cli`)
- Maven
- Lombok
- Keycloak rodando na sua máquina 
- Docker (`docker build -t hp-personagens-app .
  docker run -p 3000:3000 hp-personagens-app`)

---


### Rodando o backend

 1. Clone este repositório
git clone https://github.com/Maysa0807/hp-personagens.git

 2. Acesse a pasta do projeto
cd hp-personagens

 3. Dê permissão de execução ao Maven Wrapper (Linux/macOS)
chmod +x mvnw

 4. Rode a aplicação
./mvnw spring-boot:run

A API estará disponível em: http://localhost:3000


---

### Rodando o Frontend (Angular) 

 1. Clone este repositório
git clone https://github.com/Maysa0807/hp-frontend.git

 2. Instale as dependências do Angular
npm install

 3. Rode a aplicação
ng serve

O frontend estará disponível em: http://localhost:4200
