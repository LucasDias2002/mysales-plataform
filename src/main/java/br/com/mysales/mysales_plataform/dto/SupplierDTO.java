package br.com.mysales.mysales_plataform.dto;

import br.com.mysales.mysales_plataform.model.Supplier;

public record SupplierDTO(Long id,
                          String name,
                          String contact,
                          String email) {
    public SupplierDTO(Supplier supplier){
        this(supplier.getId(), supplier.getName(), supplier.getContact(), supplier.getEmail());
    }
}
