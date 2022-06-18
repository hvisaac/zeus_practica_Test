package com.practical.repositories;

import com.practical.models.EmployeeModel;
import com.practical.models.EmployeeWorkedHoursModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeWorkedHoursRepository extends CrudRepository<EmployeeWorkedHoursModel, Integer> {

    @Query(value="select * from employee_worked_hours where worked_date=? and employee_id=?" , nativeQuery = true)
    List<EmployeeWorkedHoursModel> findWork(String date, int employee_id);

    @Query(value="select worked_hours from employee_worked_hours where employee_id=? and worked_date BETWEEN ? AND ?" , nativeQuery = true)
    List<Integer> totalWorkedHours(int employee_id, String start_date, String end_date);

}
