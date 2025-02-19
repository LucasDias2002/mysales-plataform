package br.com.mysales.mysales_plataform.controller;

import br.com.mysales.mysales_plataform.dto.ProductDTO;
import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.repository.RepositoryProduct;
import br.com.mysales.mysales_plataform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping()
    public List<ProductDTO> ListProducts(){
        return service.listProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
}
