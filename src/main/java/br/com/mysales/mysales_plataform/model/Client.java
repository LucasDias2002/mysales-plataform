package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String contact;

    private Boolean active = true;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Sale> sales = new ArrayList<>();

    public Client(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void updateClient(Client client){
        if(client.getName() != null)
            this.name = client.getName();
        if(client.getContact() != null)
            this.contact = client.getContact();
    }

    public void updateActive(){
        this.active = false;
    }
}
