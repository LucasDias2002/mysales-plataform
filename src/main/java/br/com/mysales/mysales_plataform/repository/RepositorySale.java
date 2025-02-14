package br.com.mysales.mysales_plataform.repository;

import br.com.mysales.mysales_plataform.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySale extends JpaRepository<Sale, Long> {
}
