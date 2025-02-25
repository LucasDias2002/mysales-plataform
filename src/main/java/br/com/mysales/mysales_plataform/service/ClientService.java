package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.ClientDTO;
import br.com.mysales.mysales_plataform.model.Client;
import br.com.mysales.mysales_plataform.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<ClientDTO> list(){
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Client::getName))
                .map(c -> new ClientDTO(c.getId(), c.getName(), c.getContact()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ClientDTO> create(Client client){
        repository.save(client);
        return list();
    }

    @Transactional
    public List<ClientDTO> update(Client client){
        repository.save(client);
        return list();
    }

    @Transactional
    public List<ClientDTO> delete(Long id){
        repository.deleteById(id);
        return list();
    }
}
