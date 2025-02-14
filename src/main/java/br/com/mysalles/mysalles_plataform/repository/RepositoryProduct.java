package br.com.mysalles.mysalles_plataform.repository;

import br.com.mysalles.mysalles_plataform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product, Long> {
}
