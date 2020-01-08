package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    public void realizaCompra(CompraDTO compra) {

        // permite realizar requisição SÍNCRONAS via POST/GET através de métodos específicos
        RestTemplate client = new RestTemplate();

        // Chama o serviço de fornecedor a url específica para obter as informações de um estado
        ResponseEntity<InfoFornecedorDTO> exchange =
                client.exchange(
                        "http://localhost:8081/info/" + compra.getEndereco().getEstado(),
                        HttpMethod.GET,
                        null,
                        InfoFornecedorDTO.class
                );

        System.out.println(exchange.getBody().getEndereco());

    }
}
