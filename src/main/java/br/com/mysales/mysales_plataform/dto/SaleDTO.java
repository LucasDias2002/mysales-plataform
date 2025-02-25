package br.com.mysales.mysales_plataform.dto;

import java.time.LocalDateTime;

public record SaleDTO(Long id,
                      Double priceFinal,
                      LocalDateTime date,
                      Double debit,
                      Boolean paid,
                      Long client_id) {
}
