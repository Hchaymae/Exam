package org.jee.system.service;

import org.jee.system.dao.ProjectDAO;
import org.jee.system.dao.jpa.ProjectDAOJPA;
import org.jee.system.model.Project;

import java.util.List;

public class ProjectService {
    ProjectDAO projectDAO;

    public ProjectService(){
        this.projectDAO = new ProjectDAOJPA();
    }

    public int addProjectService(Project project){
        return projectDAO.addProject(project);
    }
    public List<Project> findAllService(){
        return projectDAO.findAll();
    }
}
