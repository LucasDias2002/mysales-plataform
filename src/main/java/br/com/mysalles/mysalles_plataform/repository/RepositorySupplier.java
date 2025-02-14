package br.com.mysalles.mysalles_plataform.repository;

import br.com.mysalles.mysalles_plataform.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySupplier extends JpaRepository<Supplier, Long> {
}
