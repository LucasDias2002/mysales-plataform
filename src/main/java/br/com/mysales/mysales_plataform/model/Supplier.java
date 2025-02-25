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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    private String email;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Supplier(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
    }
}
