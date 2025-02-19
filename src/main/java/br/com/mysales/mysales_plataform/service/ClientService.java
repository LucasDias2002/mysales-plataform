package br.com.mysales.mysales_plataform.service;

import br.com.mysales.mysales_plataform.dto.ClientDTO;
import br.com.mysales.mysales_plataform.model.Client;
import br.com.mysales.mysales_plataform.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    RepositoryClient repository;

    public List<ClientDTO> listClients(){
        return repository.findAll().stream()
                .map(c -> new ClientDTO(c.getId(), c.getName(), c.getContact()))
                .collect(Collectors.toList());
    }

    public Client saveClient(Client client){
        return repository.save(client);
    }
}
