package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    private String email;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Supplier(){}

    public Supplier(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nContato: " + contact + "\nEmail: " + email + "\n********************";
    }
}
