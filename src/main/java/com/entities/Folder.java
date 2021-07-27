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
import javax.persistence.ManyToOne;

@Entity
public class Folder {

	
	public Folder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_folder;
	private String name;
	private String reference;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user") 
	private User user;

    @OneToMany (fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_folder") 
	private List<Task> tasks = new ArrayList<Task>();

	public Folder(String name, String reference) {
		super();
		this.name = name;
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "Folder [id_folder=" + id_folder + ", name=" + name + ", reference=" + reference + ", user=" + user
				+ ", tasks=" + tasks + "]";
	}

	public long getId_folder() {
		return id_folder;
	}

	public void setId_folder(long id_folder) {
		this.id_folder = id_folder;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
