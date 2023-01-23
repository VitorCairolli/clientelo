package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.dto.OrderDTO;
import br.com.alura.clientelo.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> getOrders(
            @PageableDefault(sort = {"date", "client.name"}) Pageable pageable) {

        var orderPage = service.findPage(pageable);

        if (orderPage.isEmpty())
            return ResponseEntity.notFound().build();

        Page<OrderDTO> orderDTOPage = orderPage.map(OrderDTO::from);

        return ResponseEntity.ok(orderDTOPage);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO inputOrderDTO, UriComponentsBuilder uriBuilder) {

        var order = service.create(inputOrderDTO.toEntity());

        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();

        return ResponseEntity.created(uri).body(OrderDTO.from(order));
    }
}
