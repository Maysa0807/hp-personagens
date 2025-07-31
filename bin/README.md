# Harry Potter Personagens — API + Frontend (https://github.com/Maysa87/hp-frontend)

Uma aplicação completa com backend em Java Spring Boot e frontend em Angular para visualizar personagens em Cards inspirados no universo de Harry Potter. O projeto utiliza arquitetura REST e é estilizado com Bootstrap com estética mágica.

---

## Funcionalidades

-  API RESTful para gerenciamento dos personagens
-  Filtro de busca por nome e casa de Hogwarts
-  Frontend Angular integrado ao backend
-  Estilo visual inspirado em Hogwarts (com Bootstrap e tema personalizado)
-  Cards de personagens com imagens

---

## Tecnologias Utilizadas

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

### Frontend
- Angular 17
- Bootstrap 
- HTML + CSS + TypeScript

---

## 🛠️ Como rodar o projeto localmente

### Pré-requisitos

- Java 21 instalado
- Node.js
- Angular CLI (`npm install -g @angular/cli`)
- Maven

---


### Rodando o backend

 1. Clone este repositório
git clone https://github.com/Maysa87/hp-personagens.git

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
git clone https://github.com/Maysa87/hp-frontend.git

 2. Instale as dependências do Angular
npm install

 3. Rode a aplicação
ng serve

O frontend estará disponível em: http://localhost:4200
