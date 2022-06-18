package com.practical.repositories;

import com.practical.models.GenderModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends CrudRepository<GenderModel, Integer> {
}
