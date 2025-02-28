package br.com.mysales.mysales_plataform.dto;

import br.com.mysales.mysales_plataform.model.Sale;

import java.time.LocalDateTime;

public record SaleDTO(Long id,
                      Double priceFinal,
                      LocalDateTime date,
                      Double debit,
                      Boolean paid,
                      Long client_id) {
    public SaleDTO(Sale sale){
        this(sale.getId(), sale.getPriceFinal(), sale.getDate(), sale.getDebit(), sale.getPaid(), sale.getClient().getId());
    }

}
