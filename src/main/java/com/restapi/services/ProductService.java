package com.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.models.entities.Product;
import com.restapi.models.entities.Supplier;
import com.restapi.models.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    // public List<Product> findByName(String name) {
    // return productRepo.findByNameContains(name);
    // }

    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findOne(productId);
        if (product == null) {
            throw new RuntimeException("Product with ID " + productId + " not found");
        }
        product.getSuppliers().add(supplier);
    }

    public Product findByProductName(String name) {
        return productRepo.findByProductName(name);
    }

    public List<Product> findByProductNameLike(String name) {
        return productRepo.findByProductsLike("%" + name + "%");
    }

    public List<Product> findByCategory(Long categoryId) {
        return productRepo.findByCategory(categoryId);
    }

    public List<Product> findBySupplier(Long supplierId) {
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null) {
            return new ArrayList<>();
        }
        return productRepo.findBySupplier(supplier);
    }

}
