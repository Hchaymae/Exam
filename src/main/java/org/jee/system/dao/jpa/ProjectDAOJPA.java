package org.jee.system.dao.jpa;

import jakarta.persistence.*;
import org.jee.system.dao.ProjectDAO;
import org.jee.system.model.Employee;
import org.jee.system.model.Project;

import java.util.List;

public class ProjectDAOJPA implements ProjectDAO {

    private EntityManagerFactory entityManagerFactory;
    @PersistenceContext(unitName = "Eclipselink")
    private EntityManager entityManager;


    public ProjectDAOJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }
    @Override
    public int addProject(Project project) {
        if(project == null) {
            return 0;
        }else{
            entityManager.persist(project);
            entityManager.getTransaction().commit();
            return 1;
        }
    }

    @Override
    public List<Project> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM projet", Project.class).getResultList();
    }

    @Override
    public int findProjectIdByName(String name) {
        try {
            Project project = entityManager.createQuery("SELECT p FROM Project p WHERE p.name = :name", Project.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return project.getId();
        } catch (NoResultException e) {
            return -1;
        }
    }
}
