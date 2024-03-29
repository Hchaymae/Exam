package org.jee.system.Bean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import org.jee.system.model.Project;
import org.jee.system.service.ProjectService;

import java.util.List;

@ManagedBean(name="projectBean")
@SessionScoped
public class ProjectBean {
    private List<Project> projects;
    private ProjectService projectService;
    private Project project;

    public ProjectBean(List<Project> projects, ProjectService projectService, Project project) {
        this.projectService = projectService;
        this.projects = projectService.findAllService();
        this.project = project;
    }
}
