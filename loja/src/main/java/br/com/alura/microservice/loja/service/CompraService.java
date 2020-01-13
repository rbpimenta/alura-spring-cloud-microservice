package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public void realizaCompra(CompraDTO compra) {

        // Quem faz agora a requisição para o fornecedor é a interface FornecedorClient
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
        System.out.println(info.getEndereco());
    }

    /*
        > Com a implementação do Spring Feign a implementação abaixo foi toda comentada.

    @Autowired
    private RestTemplate client;

    *//*
     * Autowired desnecessário, somente utilizado para visualizar as instâncias
     * que o Ribbon está utilizando
     *//*
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

    }*/
}
