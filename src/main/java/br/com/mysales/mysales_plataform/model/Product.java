package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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

    public Product (){}

    public Product(String name, Double price, String description, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<SaleItem> getSales() {
        return sales;
    }

    public void setSales(List<SaleItem> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nPreço: " + price + "\nDescrição: " + description + "\n***********************";
    }
}
