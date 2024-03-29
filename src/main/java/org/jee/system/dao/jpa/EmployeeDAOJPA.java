package org.jee.system.dao.jpa;

import jakarta.persistence.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.jee.system.dao.EmployeeDAO;
import org.jee.system.model.Employee;
import org.jee.system.model.Employee_Project;
import org.jee.system.model.Project;

import java.util.List;

public class EmployeeDAOJPA implements EmployeeDAO {

    private EntityManagerFactory entityManagerFactory;
    @PersistenceContext(unitName = "Eclipselink")
    private EntityManager entityManager;


    public EmployeeDAOJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Override
    public int addEmployee(Employee employee) {
        if(employee == null) {
            return 0;
        }else{
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return 1;
        }
    }
    @Override
    public List<Employee> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM employee", Employee.class).getResultList();
    }
    @Override
    public int findEmployeeIdByName(String name) {
        try {
            Employee employee = entityManager.createQuery("SELECT p FROM Employee p WHERE p.name = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return employee.getId();
        } catch (NoResultException e) {
            return -1;
        }
    }
    @Override
    public int affecterproject(int employeeid , int projectid, int implicationPercentage) {
        try {
            Employee_Project employeeProject = new Employee_Project();
            employeeProject.setId_employee(employeeid);
            employeeProject.setId_project(projectid);
            employeeProject.setImplication(implicationPercentage);

            entityManager.persist(employeeProject);
            entityManager.getTransaction().commit();

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    @Override
    public int removeAffectationProject(int projectid, int employeeid) {
        try {
            Employee_Project employeeProject = entityManager.createQuery(
                            "SELECT ep FROM Employee_Project ep WHERE ep.id_employee = :employeeid AND ep.id_project = :projectid",
                            Employee_Project.class)
                    .setParameter("employeeid", employeeid)
                    .setParameter("projectid", projectid)
                    .getSingleResult();

            entityManager.remove(employeeProject);
            entityManager.getTransaction().commit();

            return 1;
        } catch (NoResultException e) {
            return -1;
        }
    }
}
