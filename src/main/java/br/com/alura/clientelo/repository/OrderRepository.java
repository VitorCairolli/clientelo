package br.com.alura.clientelo.repository;

import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByClient(Client client);
}
