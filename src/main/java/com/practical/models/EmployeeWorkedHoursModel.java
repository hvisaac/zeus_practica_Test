package com.practical.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_worked_hours")
public class EmployeeWorkedHoursModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private int employee_id;
    private int worked_hours;
    @Column(name = "worked_date")
    private LocalDate worked_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getWorked_hours() {
        return worked_hours;
    }

    public void setWorked_hours(int worked_hours) {
        this.worked_hours = worked_hours;
    }

    public LocalDate getWorked_date() {
        return worked_date;
    }

    public void setWorked_date(LocalDate worked_date) {
        this.worked_date = worked_date;
    }
}
