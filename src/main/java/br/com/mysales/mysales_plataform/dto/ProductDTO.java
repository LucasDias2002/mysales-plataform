package br.com.mysales.mysales_plataform.dto;

import br.com.mysales.mysales_plataform.model.Product;

public record ProductDTO(Long id,
                         String name,
                         Double price,
                         String description) {
    public ProductDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }
}
