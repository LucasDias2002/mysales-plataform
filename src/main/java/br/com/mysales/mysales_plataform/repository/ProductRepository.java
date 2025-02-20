package br.com.mysales.mysales_plataform.repository;

import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findBySupplier(Supplier supplier);
}
