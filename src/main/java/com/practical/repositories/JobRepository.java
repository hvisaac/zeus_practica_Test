package com.practical.repositories;

import com.practical.models.JobModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<JobModel, Integer> {
}
