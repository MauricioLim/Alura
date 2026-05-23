# 🎬 ScreenMatch

Projeto desenvolvido para fins de **estudo do ecossistema Java com Spring Framework**, como parte de uma jornada de aprendizado prático.

---

## 📚 Sobre o projeto

O ScreenMatch é uma aplicação de linha de comando que busca informações de séries e episódios através da API [OMDb](https://www.omdbapi.com/), processa os dados recebidos e os exibe de forma organizada no terminal.

O usuário pode pesquisar uma série pelo nome, visualizar todas as temporadas e episódios, ver os Top 5 episódios mais bem avaliados e filtrar episódios por ano de lançamento.

---

## 🧠 Tópicos abordados

- **Spring Framework com linha de comando** — configuração e uso do Spring em uma aplicação sem interface web, utilizando o terminal como ponto de entrada
- **Git e GitHub colaborativo** — versionamento de código com boas práticas de commits e uso de repositórios remotos
- **Desserialização de dados com Jackson** — consumo de JSON retornado por uma API REST e mapeamento para objetos Java usando `@JsonAlias` e `@JsonIgnoreProperties`
- **Funções lambda** — aplicação de boas práticas com expressões lambda para tornar o código mais conciso e legível
- **Streams** — manipulação de coleções de dados com a API de Streams do Java, incluindo `filter`, `map`, `flatMap`, `sorted`, `limit` e `collect`
- **Estatísticas personalizadas** — geração de rankings e filtros customizados, como Top 5 episódios e filtragem por data de lançamento

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Jackson Databind
- API OMDb

---

## 📁 Estrutura do projeto

```
src/main/java/com/example/scrrenmatch/ScreenMatch/
├── model/
│   ├── Episodio.java
│   ├── EpisodioModel.java
│   ├── SerieModel.java
│   └── TemporadaModel.java
├── service/
│   ├── ConsumoAPI.java
│   ├── ConverteDados.java
│   └── IConverteDados.java
└── principal/
    └── Principal.java
```

---

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/screenmatch.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd screenmatch
   ```

3. Execute com Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Digite o nome de uma série quando solicitado e explore os resultados!

---

## 📝 Observação

Este projeto foi desenvolvido exclusivamente para fins educacionais.
