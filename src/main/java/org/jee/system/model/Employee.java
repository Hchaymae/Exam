package org.jee.system.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="employee")
public class Employee {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id ;
        private String name;
        private String email;
        @ManyToMany(targetEntity=Project.class)
        private List projects;
        private List<String> skills;
        private Post post;

        public Employee() {
                super();
        }

        public Employee(int id, String name, String email, List<Project> projects, List<String> skills, Post post) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.projects = projects;
                this.skills = skills;
                this.post = post;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public List<Project> getProjects() {
                return projects;
        }

        public void setProjects(List<Project> projects) {
                this.projects = projects;
        }

        public List<String> getSkills() {
                return skills;
        }

        public void setSkills(List<String> skills) {
                this.skills = skills;
        }

        public Post getPost() {
                return post;
        }

        public void setPost(Post post) {
                this.post = post;
        }
}
