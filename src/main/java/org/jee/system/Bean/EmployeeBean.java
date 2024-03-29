package org.jee.system.Bean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.component.html.HtmlCommandButton;
import org.jee.system.model.Employee;
import org.jee.system.service.EmployeeService;

import java.util.List;

@ManagedBean(name="employeeBean")
@SessionScoped
public class EmployeeBean {
    private List<Employee> employees;
    private EmployeeService employeeService;
    private Employee employee;
    private HtmlCommandButton affecterButton;


    public EmployeeBean(List<Employee> employees, EmployeeService employeeService, Employee employee) {
        this.employeeService = employeeService;

        this.employees = employeeService.findAllService();
        this.employee = employee;
        this.affecterButton = new HtmlCommandButton();
    }



}
