package org.jee.system.dao;

import org.jee.system.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public int addEmployee(Employee employee);
    public List<Employee> findAll();
    public int affecterproject(int employeeid, int projectid,int implication);
    public int removeAffectationProject(int projectid,int employeeid);
    public int findEmployeeIdByName(String name);
}
