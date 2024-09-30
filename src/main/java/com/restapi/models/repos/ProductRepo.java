package com.restapi.models.repos;

import jakarta.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restapi.models.entities.Product;
import com.restapi.models.entities.Supplier;

public interface ProductRepo extends CrudRepository<Product, Long> {

    // List<Product> findByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findByProductName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findByProductsLike(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findByCategory(@PathParam("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
    public List<Product> findBySupplier(@PathParam("supplier") Supplier supplier);

}
