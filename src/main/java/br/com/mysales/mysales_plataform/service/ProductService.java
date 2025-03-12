package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.ProductDTO;
import br.com.mysales.mysales_plataform.model.Product;
import br.com.mysales.mysales_plataform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductDTO> list(){
        return repository.findAllByActiveTrue().stream()
                .sorted(Comparator.comparing(Product::getId))
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getDescription()))
                .collect(Collectors.toList());
    }

    public ProductDTO listId(Long id){
        return new ProductDTO(repository.getReferenceById(id));
    }

    @Transactional
    public ProductDTO create(Product product){
        return new ProductDTO(repository.save(product));
    }

    @Transactional
    public ProductDTO update(Product product){
        var produtoBD = repository.getReferenceById(product.getId());
        produtoBD.updateProduct(product);
        return new ProductDTO(produtoBD);
    }

    @Transactional
    public ProductDTO delete(Long id){
        var product = repository.getReferenceById(id);
        product.updateActive();
        return new ProductDTO(product);
    }
}
