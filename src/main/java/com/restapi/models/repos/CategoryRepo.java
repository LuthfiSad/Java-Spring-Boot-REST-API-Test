package com.restapi.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.restapi.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

}
