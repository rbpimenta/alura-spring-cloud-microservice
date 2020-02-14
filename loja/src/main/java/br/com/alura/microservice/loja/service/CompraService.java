package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDTO compraDTO) {

        final String estado = compraDTO.getEndereco().getEstado();

        LOG.info("Buscando informações do fornecedor de {}", estado);

        // Quem faz agora a requisição para o fornecedor é a interface FornecedorClient
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);

        // Realiza pedido
        LOG.info("Realizando um pedido");
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compraDTO.getItens());

        // Cria objeto da Compra
        Compra compra = new Compra();
        compra.setPedidoId(pedido.getId());
        compra.setTempoDePreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(compraDTO.getEndereco().toString());

        return compra;
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
