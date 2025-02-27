package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    @NotBlank
    @Email(message = "O email digitado é invalido!")
    private String email;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Supplier(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

    public void updateSupplier(Supplier supplier){
        if(supplier.getName() != null)
            this.name = supplier.getName();
        if(supplier.getContact() != null)
            this.contact = supplier.getContact();
        if(supplier.getEmail() != null)
            this.email = supplier.getEmail();
    }
}
