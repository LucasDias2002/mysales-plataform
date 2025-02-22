package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.ProductDTO;
import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductDTO> list(){
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Product::getId))
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getDescription()))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> create(Product product){
        repository.save(product);
        return list();
    }

    public List<ProductDTO> update(Product product){
        repository.save(product);
        return list();
    }

    public List<ProductDTO> delete(Long id){
        repository.deleteById(id);
        return list();
    }
}
