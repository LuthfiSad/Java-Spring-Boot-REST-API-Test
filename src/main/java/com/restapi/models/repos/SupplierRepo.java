package com.restapi.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.restapi.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

    Supplier findByEmail(String email);

}
