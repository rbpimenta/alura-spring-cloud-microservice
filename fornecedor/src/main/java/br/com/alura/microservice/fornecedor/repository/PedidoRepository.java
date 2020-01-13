package br.com.alura.microservice.fornecedor.repository;

import br.com.alura.microservice.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
