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
