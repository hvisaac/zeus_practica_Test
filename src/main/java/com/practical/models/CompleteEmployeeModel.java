package com.practical.models;

import com.practical.services.JobService;

import javax.persistence.Column;
import java.time.LocalDate;

public class CompleteEmployeeModel {

    private int id;
    private GenderModel gender_id;
    private JobModel job_id;
    private String name;
    private String last_name;
    private LocalDate birthdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GenderModel getGender_id() {
        return gender_id;
    }

    public void setGender_id(GenderModel gender_id) {
        this.gender_id = gender_id;
    }

    public JobModel getJob_id() {
        return job_id;
    }

    public void setJob_id(JobModel job_id) {
        this.job_id = job_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
