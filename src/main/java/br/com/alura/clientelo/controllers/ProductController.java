package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.dto.OutputAllProductDTO;
import br.com.alura.clientelo.dto.ProductDTO;
import br.com.alura.clientelo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<OutputAllProductDTO> getProducts() {
        var products = service.findAll();

        if (products.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(OutputAllProductDTO.from(products));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long productId) {
        var product = service.findById(productId);

        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(ProductDTO.from(product.get()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO inputProductDTO) {

        var product = service.create(inputProductDTO.toEntity());

        return ResponseEntity.ok(ProductDTO.from(product));
    }
}
