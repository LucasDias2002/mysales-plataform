package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.SaleDTO;
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
        return repository.findAllByActiveTrue().stream()
                .sorted(Comparator.comparing(Supplier::getId))
                .map(s -> new SupplierDTO(s.getId(),s.getName(), s.getContact(), s.getEmail()))
                .collect(Collectors.toList());
    }

    @Transactional
    public SupplierDTO create(Supplier supplier){
        return new SupplierDTO(repository.save(supplier));
    }

    @Transactional
    public SupplierDTO update(Supplier supplier){
        var supplierBD = repository.getReferenceById(supplier.getId());
        supplierBD.updateSupplier(supplier);
        return new SupplierDTO(supplierBD);
    }

    @Transactional
    public SupplierDTO delete(Long id){
        var supplier = repository.getReferenceById(id);
        supplier.updateActive();
        return new SupplierDTO(supplier);
    }
}
