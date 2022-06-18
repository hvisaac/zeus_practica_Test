package com.practical.controllers;

import com.practical.models.CompleteEmployeeModel;
import com.practical.models.EmployeeModel;
import com.practical.services.EmployeeService;
import com.practical.services.GenderService;
import com.practical.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    GenderService genderService;

    @Autowired
    JobService jobService;

    @GetMapping()
    public ArrayList<EmployeeModel> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/job")
    public Map<String, Object> getEmployeesByJob(@RequestParam("job_id") int id){
        Map<String, Object> response = new HashMap<>();
        if (jobService.ExistJob(id)) {
            List<EmployeeModel> employeeModelList = employeeService.getEmployeesByJob(id);
            List<CompleteEmployeeModel> completeEmployeeModelList = new ArrayList<>();
            for (EmployeeModel employeeModel : employeeModelList) {
                CompleteEmployeeModel completeEmployeeModel = new CompleteEmployeeModel();
                completeEmployeeModel.setId(employeeModel.getId());
                completeEmployeeModel.setGender_id(genderService.findGender(employeeModel.getGender_id()));
                completeEmployeeModel.setJob_id(jobService.findJob(employeeModel.getJob_id()));
                completeEmployeeModel.setName(employeeModel.getName());
                completeEmployeeModel.setLast_name(employeeModel.getLast_name());
                completeEmployeeModel.setBirthdate(employeeModel.getBirthdate());
                completeEmployeeModelList.add(completeEmployeeModel);
            }
            response.put("employees" , completeEmployeeModelList);
            response.put("success", true);
        } else {
            response.put("success", false);
        }
        return response;
    }

    @PostMapping()
    public Map<String, Object> saveEmployee(@RequestBody EmployeeModel employee){

        ArrayList<EmployeeModel> employees = this.employeeService.getEmployees();
        String requestName = employee.getName() + " " + employee.getLast_name();

        //Exist in database
        boolean existName = false;
        for (EmployeeModel employeeModel : employees) {
            String auxName;
            auxName = employeeModel.getName() + " " + employeeModel.getLast_name();
            if (auxName.equals(requestName)) {
                existName = true;
                break;
            }
        }

        //Is Older
        boolean HeIsOlder = true;
        int currentYear = LocalDate.now().getYear();
        int employeeYear = employee.getBirthdate().getYear();
        if ((currentYear - employeeYear) < 18)
        {
            HeIsOlder = false;
        }

        //Gender Exist
        boolean GenderExist = genderService.ExistGender(employee.getGender_id());
        //Job Exist
        boolean JobExist = jobService.ExistJob(employee.getJob_id());

        Map<String, Object> response = new HashMap<>();
        if (!existName && HeIsOlder && GenderExist && JobExist) {
            EmployeeModel employeeModel = this.employeeService.saveEmployee(employee);
            System.out.println(employeeModel.getId());
            System.out.println(employeeModel.getName());
            response.put("id", employeeModel.getId());
            response.put("success", true);
        } else {
            response.put("id", null);
            response.put("success", false);
        }

        return response;
    }

}
