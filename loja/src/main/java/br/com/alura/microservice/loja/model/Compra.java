package br.com.alura.microservice.loja.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Compra {
    @Id
    private Long pedidoId;
    private Integer tempoDePreparo;
    private String enderecoDestino;
}
