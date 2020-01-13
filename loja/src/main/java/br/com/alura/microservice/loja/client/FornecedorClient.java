package br.com.alura.microservice.loja.client;

import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
