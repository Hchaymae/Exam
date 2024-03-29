package org.jee.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_project")
public class Employee_Project {
    @Id
    private int id;
    private int id_employee;
    private int id_project;
    private int implication;

    public Employee_Project() {
        super();
    }

    public Employee_Project(int id_employee, int id_project, int implication) {
        this.id_employee = id_employee;
        this.id_project = id_project;
        this.implication = implication;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public int getImplication() {
        return implication;
    }

    public void setImplication(int implication) {
        this.implication = implication;
    }
}
