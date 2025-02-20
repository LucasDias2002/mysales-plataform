package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double priceFinal;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SaleItem> products = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime date;
    private Double debit;
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Sale(){}

    public Sale(Double priceFinal, Double debit, Boolean paid, Client client) {
        this.priceFinal = priceFinal;
        this.debit = debit;
        this.paid = paid;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(Double priceFinal) {
        this.priceFinal = priceFinal;
    }

    public List<SaleItem> getProducts() {
        return products;
    }

    public void setProducts(List<SaleItem> products) {
        this.products = products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", priceFinal=" + priceFinal +
                ", products=" + products +
                ", date=" + date +
                ", debit=" + debit +
                ", paid=" + paid +
                ", client_id=" + client +
                '}';
    }
}
