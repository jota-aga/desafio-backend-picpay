
## Sobre## API PicPay Simplificado

Tive como objetivo solucionar o desafio proposto pela PicPay em uma de suas seleções. Usei meu conhecimento em Spring Boot e em APIs RESTful para solucionar da maneira mais limpa e objetiva possível. O [link](https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file) do desafio. Estou listando alguns endpoints, pois o desafio deixa em aberto os outros endpoints necessários da API.
## Endpoints



### 1. Criar usuario

**POST** `/add`

Cria um novo usuário.

**Corpo da requisição:**
```json
{
    "name": "João Henrique",
    "cpf": "12345678978",
    "email": "joao@email.com",
    "password": "123456",
    "userType": "MERCHANT"
}
```

### 2. Depositar quantia

**PUT** `/deposite`

Deposita um valor ao balanço do usuário.

**Corpo da requisição:**
```json
{
    "userId": 1,
    "value": 200
}
```

### 3. Fazer uma transferência

**POST** `/transfer`

Faz uma transferência entre usuários.

**Corpo da requisição:**
```json
{
    "payer": 1,
    "payee": 2,
    "value": 300
}
```
