# People-API
Gerencie pessoas com esta api.

## Tecnologias utilizadas
* Java 17
* Spring Boot
* H2
* Docker

## Como rodar o projeto
Com Java 17 na sua máquina, execute o comando abaixo:
```sh
./gradlew clean build
./gradlew bootBuildImage
docker-compose up
```

### Cadastrar uma pessoa
POST

    localhost:8080/api/v1/person

#### Body enviado

```json
{
  "name": "Daenerys Targaryen",
  "birthDate": "2000-05-21",
  "address": [
    {
      "street": "Valyria",
      "postalCode": "0000",
      "number": "01",
      "city": "Shit",
      "mainAddress": false
    }
  ]
}

```
Mais informações sobre a API, acesse o link abaixo:
http://localhost:8080/swagger-ui.html
