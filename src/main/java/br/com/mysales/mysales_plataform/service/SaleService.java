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
    public SaleDTO create(Sale sale){
        Optional<Client> client = ClientRepository.findById(sale.getClient().getId());
        client.ifPresent(sale::setClient);

        for (SaleItem item : sale.getProducts()) {
            item.setSale(sale);
        }

        return new SaleDTO(repository.save(sale));
    }

    @Transactional
    public SaleDTO update(Sale sale) {
        var saleBD = repository.getReferenceById(sale.getId());
        return new SaleDTO(saleBD.updateSale(sale));
    }

    @Transactional
    public SaleDTO delete(Long id){
        var sale = repository.getReferenceById(id);
        sale.updateActive();
        return new SaleDTO(sale);
    }
}
