package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.dto.OrderDTO;
import br.com.alura.clientelo.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long orderId) {
        var order = service.findById(orderId);

        if (order.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(OrderDTO.from(order.get()));
    }

    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<Page<OrderDTO>> getOrders(@PathVariable int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 20, Sort.by("date", "client").ascending());
        var orderPage = service.findPage(pageable);

        if (orderPage.isEmpty())
            return ResponseEntity.notFound().build();

        Page<OrderDTO> orderDTOPage = orderPage.map(OrderDTO::from);

        return ResponseEntity.ok(orderDTOPage);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO inputOrderDTO) {

        var order = service.create(inputOrderDTO.toEntity());

        return ResponseEntity.ok(OrderDTO.from(order));
    }
}
