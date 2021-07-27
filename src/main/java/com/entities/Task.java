package com.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_task;
	private String text;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folder")
	private Folder folder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sharedfolder")
	private SharedFolder sharedfolder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project")
	private Project project;

	public Task(String text) {
		super();
		this.text = text;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Task [id_task=" + id_task + ", text=" + text + ", folder=" + folder + ", sharedfolder=" + sharedfolder
				+ ", project=" + project + "]";
	}

	public long getId_task() {
		return id_task;
	}

	public void setId_task(long id_task) {
		this.id_task = id_task;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public SharedFolder getSharedfolder() {
		return sharedfolder;
	}

	public void setSharedfolder(SharedFolder sharedfolder) {
		this.sharedfolder = sharedfolder;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
