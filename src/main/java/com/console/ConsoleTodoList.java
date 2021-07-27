package com.console;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entities.Folder;
import com.entities.SharedFolder;
import com.entities.Task;
import com.entities.User;

public class ConsoleTodoList {

	public static void main(String[] args) {

	       EntityManagerFactory entityManagerFactory = null;
	       EntityManager em = null;
	       
	       SharedFolder projetORM = new SharedFolder("Projet ORM collectif", "6214");
	       User anis = new User("Anis", 30, "anis@pop.fr");
	       User alexis = new User("alexis", 30, "alexis@pop.fr");
	       

	       
	       Task t11 = new Task("creation DB");
	       Task t21 = new Task("Conception");
	       ArrayList<Task> lesTachesDuProjetCollectif = new ArrayList<Task>();
	       lesTachesDuProjetCollectif.add(t21); lesTachesDuProjetCollectif.add(t11);
	       projetORM.setTasks(lesTachesDuProjetCollectif);
	       	       
	       ArrayList<SharedFolder> dossiersPartages = new ArrayList<SharedFolder>();
	       dossiersPartages.add(projetORM);  
	       
	       anis.setSharedFolders(dossiersPartages);
	       alexis.setSharedFolders(dossiersPartages);
	       
	       Folder courses = new Folder("Faire les courses", "414545");
	       
	       Task t1 = new Task("acheter du pain");
	       Task t2 = new Task("acheter du gel");
	       ArrayList<Task> coursess = new ArrayList<Task>();
	       coursess.add(t2); coursess.add(t1);
	       courses.setTasks(coursess);
	       
	       ArrayList<Folder> dossiersDeAnis = new ArrayList<Folder>();
	       dossiersDeAnis.add(courses);
	       anis.setFolders(dossiersDeAnis);
	       

	        
	        try {
	            entityManagerFactory = Persistence.createEntityManagerFactory("TodoListORM");
	            em = entityManagerFactory.createEntityManager();
	            
	            EntityTransaction trans = em.getTransaction();
	            trans.begin();

				em.persist(alexis);
				em.persist(anis);

	            trans.commit(); 

	        } finally {
	            if ( em != null ) em.close();
	            if ( entityManagerFactory != null ) entityManagerFactory.close();
	        }

	}

}
