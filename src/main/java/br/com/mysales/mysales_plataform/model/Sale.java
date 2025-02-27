package br.com.mysales.mysales_plataform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Double priceFinal;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SaleItem> products = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime date;

    @NotNull
    private Double debit;
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Sale(Double priceFinal, Double debit, Boolean paid, Client client) {
        this.priceFinal = priceFinal;
        this.debit = debit;
        this.paid = paid;
        this.client = client;
    }

    public void updateSale(Sale sale){
        if(sale.getDebit() != null)
            this.debit -= sale.getDebit();
        if(sale.getPaid() != null)
            this.paid = sale.getPaid();
    }
}
