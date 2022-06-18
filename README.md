# zeus_practica_Test

## Get request

### Returns an array of employees based on job title

http://localhost:8080/employees/job?job_id="value"     


## Post request
### Returns the total hours workeds for employee
http://localhost:8080/worked_hours/totalhours

```yaml
{
  "employee_id": 1, // Id del empleado
  "start_date": “2019-01-01”, // Fecha de inicio
  "end_date": "2019-06-30", // Fecha de fin
}
```
### Returns the payment for employee based on hours worked
http://localhost:8080/worked_hours/payment

```yaml
{
  "employee_id": 1, // Id del empleado
  "start_date": “2019-01-01”, // Fecha de inicio
  "end_date": "2019-06-30", // Fecha de fin
}
```

### Register the worked employee hours
http://localhost:8080/worked_hours  

```yaml
{
  "employee_id": 1, // Id del empleado
  "worked_hours": 10, // Horas trabajadas
  "worked_date": "2019-01-01" // Fecha que trabajó el empleado
}
```

### Register a employee                                    
http://localhost:8080/employees

```yaml
{
  "gender_id": 1, // Id del catálogo genders
  "job_id": 1, // Id del catálogo jobs
  "name": "Juan", // Nombre del empleado
  "last_name": "Pérez", // Apellido del empleado
  "birthdate": "1983-01-01" // Fecha de nacimiento del empleado
}
```
