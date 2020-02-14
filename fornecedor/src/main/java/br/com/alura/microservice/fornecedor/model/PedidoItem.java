package br.com.alura.microservice.fornecedor.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;


}
