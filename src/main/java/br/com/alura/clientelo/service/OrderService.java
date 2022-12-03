package br.com.alura.clientelo.service;

import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.repository.CategoryRepository;
import br.com.alura.clientelo.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public Page<Order> findPage(Pageable pageable){

        return repository.findAll(pageable);
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    public Order create(Order newOrder){
        return repository.save(newOrder);
    }
}
