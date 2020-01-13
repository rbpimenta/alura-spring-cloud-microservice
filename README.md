# Microservices com Spring Cloud

Implementação de projeto com Spring Cloud, utilizando:

* Banco de Dados: MariaDB (Rodando via docker, ver pasta database)
* Java 8 
* Spring Initializer 
* Spring Cloud
* Postman (Requisições)
* Eureka Server (Server Discover)

### **Service Registry com Eureka**

Implementação da segunda aula do Alura com a implementação do *service registry* através do Eureka Server.

Conhecimentos adquiridos:

* _Service registry_ é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
* _Service discovery_ é um mecanismo de descoberta do IP do microsserviço pelo nome
* Implementação da comunicação entre a aplicação da **Loja** com o **Fornecedor**

### **Spring Config Server**

Vamos extrair os valores das nossas aplicações e colocá-los num servidor de 
configuração, denominado Spring Config Server, que nos permite acessar via uma API Rest
as configurações de um determinado serviço.
Os valores de application.yml vão agora para dentro de um repositório (ex: File Systems).
Basta ensinar agora o Spring Config Server a buscar tais valores.

Vamos durante as aulas:
1) Criar e configurar o Spring Config Server.

// Pasta microservice-repo é a pasta de repositórios de configurações

// Arquivo fornecedor/resources/bootstrap.yml é um arquivo "inicializado" antes de ler as configurações tradicionais (application.yml)
