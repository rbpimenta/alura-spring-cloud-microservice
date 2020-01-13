package br.com.alura.microservice.loja.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String rua;
    private int numero;
    private String estado;

    @Override
    public String toString() {
        return "EnderecoDTO{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", estado='" + estado + '\'' +
                '}';
    }
}
