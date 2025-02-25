package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
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

    private String name;
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
}
