package org.jee.system.dao;

import org.jee.system.model.Project;

import java.util.List;

public interface ProjectDAO {
    public int addProject(Project project);
    public List<Project> findAll();

    public int findProjectIdByName(String name);
}
