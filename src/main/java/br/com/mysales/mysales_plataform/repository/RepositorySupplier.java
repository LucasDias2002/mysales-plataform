package br.com.mysales.mysales_plataform.repository;

import br.com.mysales.mysales_plataform.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySupplier extends JpaRepository<Supplier, Long> {
}
