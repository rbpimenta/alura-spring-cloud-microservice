# Microservices com Spring Cloud

Implementação de projeto com Spring Cloud, utilizando:

* Banco de Dados: MariaDB (Rodando via docker, ver pasta database)
* Java 8 
* Spring Initializer 
* Spring Cloud NetFlix
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

### **Load Balancer e Spring Feign**

##### Load Balancer
Imagine que tenhamos três instâncias da aplicação fornecedor se comunicando com o 
Eureka Server. Imagine que cada instância tenham portas diferentes na Eureka.
A aplicação da Loja tem três requisições disponíveis para ela fazer e ela tem que escolher
qual a melhor.

A escolha de qual instância a aplicação vai usar para escolher a melhor instância não
é realizada pelo Eureka Server e sim pelo **Ribbon**.

O **Ribbon** faz o Client-Side Load Balancer, onde a cada requisição que ele fizer ele distribui
tais requisições para cada instância (distribuindo a carga). Esse Ribbon está "configurado" na
classe LojaApplication, quando configuramos o RestTemplate para o Eureka.

A utilização do RestTemplate em CompraService já tem a inteligência do LoadBalancer.
Vamos injetar o DiscoveryCliente para analisar o comportamento.

##### Spring Feign

Para usar iremos reconfigurar a aplicação, não utilizando mais o RestTemplate.
Nesse momento deixaremos de usar alguns métodos já utilizados na class CompraService
(que estarão comentados).

#### Distributed Tracing

Use, SL4F to track log from all microsservices, with Papertrail.

Spring Sleuth\
Documentação: \
https://spring.io/projects/spring-cloud-sleuth#overview\
https://cloud.spring.io/spring-cloud-sleuth/reference/html/

Utilizando o nome spring.application.name para exibir o log da aplicação.

# Módulo 2
## Hystrix

Biblioteca para nos auxiliar gerenciar o Circuit Breaker e o Fallback.

### Circuit Breaker
Ao tentar acessar um  micro serviço podemos "impedir" que o mesmo ultrapasse
um timeout máximo de 1 segundo, por exemplo. Isso é denominado 
Circuit Breaker.

### Fallback
Método que responde algo para o usuário quando ocorre um Circuit Breaker.

### Passo a Passo
Inclusão de \
spring-cloud-starter-netflix-hystrix

Implementação de fallback

## Bulkhead com Hystrix
Separar Threads entre os micro serviços existentes, de forma que as requisições diferentes não 
prejudiquem o uso normal do sistema por outros usuários.

Por exemplo, caso um usuário esteja inserindo informações da compra (por um POST), e ele tenha ocupado
todas as threads disponíveis do sistema, um usuário que esteja querendo ver as informações de um
produto por exemplo (a partir de um GET) não vai conseguir encontrar threads disponíveis e, com isso,
ocorrerá um falha.

A melhor abordagem é separar as threads de compra (POST) das de visualização de informação (GET), de 
forma a não prejudicar a aplicação por algum aumento de requisições de inclusão de compra, conforme 
problematizado acima.

## Spring Gateway
https://www.javainuse.com/spring/cloud-gateway-eureka

## Spring Doc API
Using this along with Spring Gateway we need to add `server.forward-headers-strategy: framework` in 
`application.yml`. For the current application we have the following:

fornecedor: 
- http://localhost:8081/swagger-ui/index.html
- http://localhost:8083/fornecedor/swagger-ui/index.html

loja: 
- http://localhost:8081/swagger-ui/index.html
- http://localhost:8083/loja/swagger-ui/index.html


https://springdoc.org/
