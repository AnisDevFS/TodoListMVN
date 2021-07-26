package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user;
	private String name;
	private int age;
	private String email;

	@OneToOne
	private Project project;

	@OneToMany
	private List<Folder> folders = new ArrayList<Folder>();

	@ManyToMany
	private List<SharedFolder> sharedFolders = new ArrayList<SharedFolder>();

	public User(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}
}
