package com.ejerciciopoo.main;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ejerciciopoo.entidades.Persona;
import com.ejerciciopoo.entidades.Ranking;
import com.ejerciciopoo.entidades.Skill;



public class Main {
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	
	

	public static void main(String[] args) {
		Persona persona= new Persona("Nery vera");
		ingresarPersona(persona);
		Persona persona1= new Persona("Pilar Baque");
		ingresarPersona(persona1);
		Persona persona2= new Persona("Nelson Vera");
		ingresarPersona(persona2);
		
		Ranking ranking= new Ranking(5);
		ingresarRanking(ranking);
		Ranking ranking1= new Ranking(2);
		ingresarRanking(ranking1);
		
		Skill skill= new Skill("Ingles");
		ingresarSkill(skill);
		Skill skil= new Skill("Redes de computdora");
		ingresarSkill(skil);
		Skill ski2= new Skill("Programacion V");
		ingresarSkill(ski2);

		
	}
	static void ingresarPersona(Persona persona) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(persona);
		session.getTransaction().commit();
		session.close();
	}
	
	static void ingresarSkill(Skill skill) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(skill);
		session.getTransaction().commit();
		session.close();

	}
	
	static void ingresarRanking(Ranking ranking) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ranking);
		session.getTransaction().commit();
		session.close();

	}

	


}
