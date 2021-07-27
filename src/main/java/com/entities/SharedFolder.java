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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SharedFolder {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_sharedfolder;
	private String name;
	private String reference;
	

    @ManyToMany
    @JoinTable( name = "clientsharedfolder",
    			joinColumns = @JoinColumn (name = "id_sharedfolder"),
                inverseJoinColumns = @JoinColumn( name = "id_user"))

	private List<User> sharedFolders = new ArrayList<User>();


    @OneToMany (fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_sharedfolder") 
	private List<Task> tasks = new ArrayList<Task>();

	public SharedFolder(String name, String reference) {
		super();
		this.name = name;
		this.reference = reference;
	}
	
	public SharedFolder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SharedFolder [id_sharedfolder=" + id_sharedfolder + ", name=" + name + ", reference=" + reference
				+ ", sharedFolders=" + sharedFolders + ", tasks=" + tasks + "]";
	}

	public long getId_sharedfolder() {
		return id_sharedfolder;
	}

	public void setId_sharedfolder(long id_sharedfolder) {
		this.id_sharedfolder = id_sharedfolder;
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

	public List<User> getSharedFolders() {
		return sharedFolders;
	}

	public void setSharedFolders(List<User> sharedFolders) {
		this.sharedFolders = sharedFolders;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
