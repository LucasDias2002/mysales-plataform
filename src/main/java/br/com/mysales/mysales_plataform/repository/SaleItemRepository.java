package br.com.mysales.mysales_plataform.repository;

import br.com.mysales.mysales_plataform.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
