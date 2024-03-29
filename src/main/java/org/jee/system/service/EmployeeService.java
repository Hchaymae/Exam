package org.jee.system.service;

import org.jee.system.dao.EmployeeDAO;
import org.jee.system.dao.jpa.EmployeeDAOJPA;
import org.jee.system.model.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO;

    public EmployeeService(){
        this.employeeDAO = new EmployeeDAOJPA();
    }

    public int addEmployeeService(Employee employee){
        return employeeDAO.addEmployee(employee);
    }

    public List<Employee> findAllService(){
        return employeeDAO.findAll();
    }

    public int affecterprojectService(int employeeid, int projectid,int implication){
        return employeeDAO.affecterproject(employeeid, projectid,implication);
    }
    public int removeAffectationProjectService(int projectid , int employeeid){
        return employeeDAO.removeAffectationProject(projectid,employeeid);
    }
}
