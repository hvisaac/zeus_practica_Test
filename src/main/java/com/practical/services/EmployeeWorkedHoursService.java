package com.practical.services;

import com.practical.models.EmployeeWorkedHoursModel;
import com.practical.repositories.EmployeeWorkedHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeWorkedHoursService {

    @Autowired
    EmployeeWorkedHoursRepository employeeWorkedHoursRepository;

    public EmployeeWorkedHoursModel registerWorkedHours(EmployeeWorkedHoursModel employeeWorkedHours){
        return employeeWorkedHoursRepository.save(employeeWorkedHours);
    }

    public boolean worked(LocalDate date, int id){
        return employeeWorkedHoursRepository.findWork(date.toString(), id).size() > 0;
    }

    public int workedHours(int employee_id, LocalDate start_date, LocalDate end_date){
        List<Integer> totalWorkedHours = employeeWorkedHoursRepository.totalWorkedHours(employee_id, start_date.toString(), end_date.toString());
        int totalhours = 0;
        for (Integer hour: totalWorkedHours){
            totalhours += hour;
        }

        return totalhours;
    }
}
