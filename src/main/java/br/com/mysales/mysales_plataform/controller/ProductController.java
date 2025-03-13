package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.ProductDTO;
import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> listId(@PathVariable Long id){
        return ResponseEntity.ok(service.listId(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody Product product, UriComponentsBuilder uriBuilder) {
        var productDTO = service.create(product);
        var uri = uriBuilder.path("/product/{id}").buildAndExpand(productDTO.id()).toUri();
        return ResponseEntity.created(uri).body(productDTO);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody Product product) {
        return ResponseEntity.ok(service.update(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
