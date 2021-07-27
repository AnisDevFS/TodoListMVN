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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {



	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user;
	private String name;
	private int age;
	private String email;

    @OneToOne( cascade = CascadeType.ALL )  
    @JoinColumn( name="id_project")
	private Project project;

    @OneToMany (fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_user") 
	private List<Folder> folders = new ArrayList<Folder>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable( name = "clientsharedfolder",
    			joinColumns = @JoinColumn (name = "id_user"),
                inverseJoinColumns = @JoinColumn( name = "id_sharedfolder"))
	private List<SharedFolder> sharedFolders = new ArrayList<SharedFolder>();

	public User(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", name=" + name + ", age=" + age + ", email=" + email + ", project="
				+ project + ", folders=" + folders + ", sharedFolders=" + sharedFolders + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	public List<SharedFolder> getSharedFolders() {
		return sharedFolders;
	}

	public void setSharedFolders(List<SharedFolder> sharedFolders) {
		this.sharedFolders = sharedFolders;
	}
}
