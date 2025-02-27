package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @Positive
    private Double price;
    private String description;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<SaleItem> sales = new ArrayList<>();

    public Product(String name, Double price, String description, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }
    
    public void updateProduct(Product product){
        if(product.getName() != null)
            this.name = product.getName();
        if(product.getPrice() != null)
            this.price = product.getPrice();
        if(product.getDescription() != null)
            this.description = product.getDescription();
    }
}
