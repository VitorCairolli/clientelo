package br.com.alura.clientelo.repository;

import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByClient(Client client);
}
