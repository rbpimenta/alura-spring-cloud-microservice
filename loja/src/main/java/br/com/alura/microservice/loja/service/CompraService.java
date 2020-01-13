package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    /**
     * Autowired desnecessário, somente utilizado para visualizar as instâncias
     * que o Ribbon está utilizando
     */
    @Autowired
    private DiscoveryClient eurekaClient;

    public void realizaCompra(CompraDTO compra) {

        // Chama o serviço de fornecedor a url específica para obter as informações de um estado
        ResponseEntity<InfoFornecedorDTO> exchange =
                client.exchange(
                        "http://fornecedor/info/" + compra.getEndereco().getEstado(),
                        HttpMethod.GET,
                        null,
                        InfoFornecedorDTO.class
                );

        // Imprime todas as instâncias do fornecedor que estão disponíveis
        this.eurekaClient.getInstances("fornecedor")
                .forEach(fornecedor -> {
                    System.out.println("localhost:" + fornecedor.getPort());
                });

        System.out.println(exchange.getBody().getEndereco());

    }
}
