package com.practical.services;


import com.practical.models.EmployeeModel;
import com.practical.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<EmployeeModel> getEmployees(){
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }

    public List<EmployeeModel> getEmployeesByJob(int id) {
        return employeeRepository.findAllByJobId(id);
    }

    public EmployeeModel saveEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }

    public boolean exist(Integer id){
        return employeeRepository.existsById(id);
    }

    public EmployeeModel findEmployee(Integer id){
        return employeeRepository.findById(id).get();
    }

}
