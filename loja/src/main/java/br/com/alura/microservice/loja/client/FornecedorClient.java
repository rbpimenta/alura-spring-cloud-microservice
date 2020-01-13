package br.com.alura.microservice.loja.client;

import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Informamos à anotação FeignClient o nome da aplicação que queremos acessar.
 * E implementamos na nossa interface os métodos dos serviços que queremos acessar.
 * Ele sabe como acessar visto que o Feign está integrado com o Ribbon e, portanto, sabe se
 * comunicar com o Eureka Server.
 *
 */
@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado (@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDTO realizaPedido(@RequestBody List<ItemDaCompraDTO> produtos);
}
