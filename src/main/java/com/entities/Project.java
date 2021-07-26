package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_project;
	private String name;
	private String reference;

	@OneToMany
	private List<Task> tasks = new ArrayList<Task>();

	public Project(String name, String reference) {
		super();
		this.name = name;
		this.reference = reference;
	}

}
