package br.com.alura.microservice.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients // Habilita a possibilidade de fazer requisições para outros serviços
@EnableCircuitBreaker
public class LojaApplication {

    /**
     * Método para criar um Bean injetável do RestTemplate
     * Necessário pois estamos utilizando o Eureka como Server Discover e, portanto,
     * precisamos da anotação {@link LoadBalanced} para a aplicação da loja reconhecer a aplicação
     * denominada "fornecedor"
     *
     * @return RestTemplate com LoadBalance
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(LojaApplication.class, args);
    }

}
