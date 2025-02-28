package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.ProductDTO;
import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping()
    public List<ProductDTO> list() {
        return service.list();
    }

    @PostMapping
    public ProductDTO create(@RequestBody Product product) {
        return service.create(product);
    }

    @PutMapping
    public ProductDTO update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("{id}")
    public ProductDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
