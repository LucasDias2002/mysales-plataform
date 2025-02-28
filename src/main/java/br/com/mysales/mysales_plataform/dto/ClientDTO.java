package br.com.mysales.mysales_plataform.dto;

import br.com.mysales.mysales_plataform.model.Client;

public record ClientDTO(Long id,
                        String name,
                        String contact) {

    public ClientDTO(Client client) {
        this(client.getId(), client.getName(), client.getContact());
    }
}
