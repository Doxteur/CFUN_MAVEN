package com.CFUN.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class RunComplexe {
	private static int nbMuscu = 4;
	private static int nbFit = 5;
	private static final String nomComplexe = "C Fun";
	private static final String TYPE = "Type opération (E)ntrée ou (S)ortie : ";
	private static final String SORTIE = "N° d'entrée à sortir : ";
	private static final String CHOIX = "(M)usculation, (F)itness : ";
	private static final String AUTRE = "Autre opération (O/N) : ";
	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select t from Todo t");
		List<Todo> connectList = q.getResultList();
		for (Todo todo : connectList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + connectList.size());

		// create new todo
		em.getTransaction().begin();
		Todo connection = new Todo();
		connection.setType("client");
		connection.setNom("Pierre");
		connection.setPrenom("DOLIVET");
		connection.setLogin("1234");
		connection.setUser("Pierrot");
		em.persist(connection);
		em.getTransaction().commit();

		em.close();
		
		Complexe leComplexe = new Complexe(nbMuscu, nbFit, nomComplexe);

		char repAutre = 'O';
		char repType;
		int repSortie;
		char repChoix;

		while (repAutre == 'O') {
			repType = Character.toUpperCase(javax.swing.JOptionPane.showInputDialog(TYPE).charAt(0));
			if (repType == 'E') {
				repChoix = Character.toUpperCase(javax.swing.JOptionPane.showInputDialog(CHOIX).charAt(0));
				Arrivee jArrive = new Arrivee(leComplexe, repChoix);
				if (leComplexe.entreeUsager(jArrive)) {
					System.out.println(jArrive.afficheBillet());
				}
			} else {
				repSortie = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(SORTIE));
				System.out.println(leComplexe.sortieUsager(repSortie).afficheTicket());
			}
			System.out.print(leComplexe.lesInfos());
			repAutre = Character.toUpperCase(javax.swing.JOptionPane.showInputDialog(AUTRE).charAt(0));
		}
		System.exit(0);
	}
}
