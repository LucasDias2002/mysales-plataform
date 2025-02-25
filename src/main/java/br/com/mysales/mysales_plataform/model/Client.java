package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String contact;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Sale> sales = new ArrayList<>();

    public Client(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}
