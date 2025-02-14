package br.com.mysalles.mysalles_plataform.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double priceFinal;
    @ManyToOne()
    private List<Product> products;
    private LocalDate date;
    private Double debit;
    private Boolean paid;
    @ManyToOne
    private Client client;

    public Sale(){}

    public Sale(Double priceFinal, LocalDate date, Double debit, Boolean paid, Client client) {
        this.priceFinal = priceFinal;
        this.date = date;
        this.debit = debit;
        this.paid = paid;
        this.client = client;
    }

    public Double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(Double priceFinal) {
        this.priceFinal = priceFinal;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
