package com.practical.controllers;

import com.practical.models.EmployeeModel;
import com.practical.models.EmployeeWorkedHoursModel;
import com.practical.models.TotalHoursModel;
import com.practical.services.EmployeeService;
import com.practical.services.EmployeeWorkedHoursService;
import com.practical.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/worked_hours")
public class EmployeeWorkedHoursController {

    @Autowired
    EmployeeWorkedHoursService employeeWorkedHoursService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JobService jobService;

    @PostMapping("/totalhours")
    public Map<String, Object> totalWorkedHours(@RequestBody TotalHoursModel totalHoursModel){
        Map<String, Object> response = new HashMap<>();
        boolean employee_exist = employeeService.exist(totalHoursModel.getEmployee_id());

        if (totalHoursModel.getStart_date().isBefore(totalHoursModel.getEnd_date()) && employee_exist) {
            int workedHours = employeeWorkedHoursService.workedHours(totalHoursModel.getEmployee_id(), totalHoursModel.getStart_date(), totalHoursModel.getEnd_date());
            response.put("total_worked_hours", workedHours);
            response.put("success", true);
        } else {
            response.put("total_worked_hours", null);
            response.put("success", false);
        }
        return response;
    }

    @PostMapping("/payment")
    public Map<String, Object> EmployeePayment(@RequestBody TotalHoursModel totalHoursModel){
        Map<String, Object> response = new HashMap<>();
        boolean employee_exist = employeeService.exist(totalHoursModel.getEmployee_id());

        if (totalHoursModel.getStart_date().isBefore(totalHoursModel.getEnd_date()) && employee_exist) {
            int workedHours = employeeWorkedHoursService.workedHours(totalHoursModel.getEmployee_id(), totalHoursModel.getStart_date(), totalHoursModel.getEnd_date());
            int job_id = employeeService.findEmployee(totalHoursModel.getEmployee_id()).getJob_id();
            float salary = jobService.findJob(job_id).getSalary();
            response.put("payment", workedHours * salary);
            response.put("success", true);
        } else {
            response.put("payment", null);
            response.put("success", false);
        }
        return response;
    }

    @PostMapping()
    public Map<String, Object> registerWorkedHours(@RequestBody EmployeeWorkedHoursModel employeeWorkedHours){
        Map<String, Object> response = new HashMap<>();
        boolean employee_exist = this.employeeService.exist(employeeWorkedHours.getEmployee_id());
        boolean worked = this.employeeWorkedHoursService.worked(employeeWorkedHours.getWorked_date(), employeeWorkedHours.getEmployee_id());
        boolean workedDate = employeeWorkedHours.getWorked_date().isBefore(LocalDate.now()) || employeeWorkedHours.getWorked_date().isEqual(LocalDate.now());

        if (
                employee_exist
                        && employeeWorkedHours.getWorked_hours() < 20
                        && workedDate
                        && !worked
        ) {
            EmployeeWorkedHoursModel employeeWorkedHoursModel = this.employeeWorkedHoursService.registerWorkedHours(employeeWorkedHours);
            response.put("id", employeeWorkedHoursModel.getEmployee_id());
            response.put("success", true);
        } else {
            response.put("id", null);
            response.put("success", false);
        }

        return response;
    }

}
