package br.com.alura.clientelo.controllers;

import br.com.alura.clientelo.dto.ProductDTO;
import br.com.alura.clientelo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(Pageable pageable) {

        var productPage = service.findAll(pageable);

        if (productPage.isEmpty())
            return ResponseEntity.notFound().build();

        Page<ProductDTO> productDTOPage = productPage.map(product -> ProductDTO.from(product));

        return ResponseEntity.ok(productDTOPage);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long productId) {
        var product = service.findById(productId);

        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(ProductDTO.from(product.get()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO inputProductDTO, UriComponentsBuilder uriBuilder) {

        var product = service.create(inputProductDTO.toEntity());

        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(ProductDTO.from(product));
    }
}
