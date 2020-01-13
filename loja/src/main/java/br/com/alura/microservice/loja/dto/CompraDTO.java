package br.com.alura.microservice.loja.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDTO {
    private List<ItemDaCompraDTO> itens;
    private EnderecoDTO endereco;
}
