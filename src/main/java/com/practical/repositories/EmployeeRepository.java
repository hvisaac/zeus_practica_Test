package com.practical.repositories;



import com.practical.models.EmployeeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Integer> {

    @Query(value="select * from employees where job_id=?" , nativeQuery = true)
    List<EmployeeModel> findAllByJobId(int job_id);
}
