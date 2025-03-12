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
        return repository.findAllByActiveTrue().stream()
                .sorted(Comparator.comparing(Client::getName))
                .map(c -> new ClientDTO(c.getId(), c.getName(), c.getContact()))
                .collect(Collectors.toList());
    }

    public ClientDTO listId(long id){
        return new ClientDTO(repository.getReferenceById(id));
    }

    @Transactional
    public ClientDTO create(Client client) {
        return new ClientDTO(repository.save(client));
    }
    @Transactional
    public ClientDTO update(Client client){
        var clientBD = repository.getReferenceById(client.getId());
        clientBD.updateClient(client);
        return new ClientDTO(clientBD);
    }

    @Transactional
    public ClientDTO delete(Long id){
        var client = repository.getReferenceById(id);
        client.updateActive();
        return new ClientDTO(client);
    }
}
