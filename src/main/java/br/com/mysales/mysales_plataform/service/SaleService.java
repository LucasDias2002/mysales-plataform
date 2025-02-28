package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.SaleDTO;
import br.com.mysales.mysales_plataform.model.Client;
import br.com.mysales.mysales_plataform.model.Sale;
import br.com.mysales.mysales_plataform.model.SaleItem;
import br.com.mysales.mysales_plataform.repository.ClientRepository;
import br.com.mysales.mysales_plataform.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    SaleRepository repository;

    @Autowired
    ClientRepository ClientRepository;

    public List<SaleDTO> list() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Sale::getDate).reversed())
                .map(s -> new SaleDTO(s.getId(), s.getPriceFinal(), s.getDate(), s.getDebit(), s.getPaid(), s.getClient().getId()))
                .collect(Collectors.toList());

    }

    @Transactional
    public List<SaleDTO> create(Sale sale){
        Optional<Client> client = ClientRepository.findById(sale.getClient().getId());
        client.ifPresent(sale::setClient);

        for (SaleItem item : sale.getProducts()) {
            item.setSale(sale);
        }

        repository.save(sale);
        return list();
    }

    @Transactional
    public List<SaleDTO> update(Sale sale) {
        var saleBD = repository.getReferenceById(sale.getId());
        saleBD.updateSale(sale);
        return list();
    }

    @Transactional
    public List<SaleDTO> delete(Long id){
        repository.deleteById(id);
        return list();
    }
}
