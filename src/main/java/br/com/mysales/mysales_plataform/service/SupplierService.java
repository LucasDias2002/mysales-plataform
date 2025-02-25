package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.SupplierDTO;
import br.com.mysales.mysales_plataform.model.Supplier;
import br.com.mysales.mysales_plataform.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository repository;

    public List<SupplierDTO> list(){
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Supplier::getId))
                .map(s -> new SupplierDTO(s.getId(),s.getName(), s.getContact(), s.getEmail()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<SupplierDTO> create(Supplier supplier){
        repository.save(supplier);
        return list();
    }

    @Transactional
    public List<SupplierDTO> update(Supplier supplier){
        repository.save(supplier);
        return list();
    }

    @Transactional
    public List<SupplierDTO> delete(Long id){
        repository.deleteById(id);
        return list();
    }
}
