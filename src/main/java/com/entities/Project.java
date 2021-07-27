package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_project;
	private String name;
	private String reference;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_project")
	private List<Task> tasks = new ArrayList<Task>();

	public Project(String name, String reference) {
		super();
		this.name = name;
		this.reference = reference;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_project() {
		return id_project;
	}

	public void setId_project(long id_project) {
		this.id_project = id_project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Project [id_project=" + id_project + ", name=" + name + ", reference=" + reference + ", tasks=" + tasks
				+ "]";
	}

}
