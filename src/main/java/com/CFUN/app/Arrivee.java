package com.CFUN.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Arrivee {
	private static int numeroSortie = 0;
	private int numeroArrivee;

	public int getNumeroArrivee() {
		return numeroArrivee;
	}

	private char choixSport;

	public char getChoixSport() {
		return choixSport;
	}

	private long horaireArrivee;
	private Calendar hDep;

	private Complexe complexe;

	public Arrivee(final Complexe complexe, final char choixSport) {
		this.horaireArrivee = Calendar.getInstance().getTimeInMillis();
		this.choixSport = choixSport;
		this.complexe = complexe;
		this.hDep = null;
	}

	public String afficheBillet() {
		final String MSGNOM = "Complexe ";
		final String MSGNUM = "Billet d'entrée n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";

		String leBillet;
		leBillet = MSGNOM + this.getComplexe().getNomComplexe() + "\t";
		leBillet += MSGNUM + this.numeroArrivee + "\n";

		Calendar leCal = Calendar.getInstance();
		leCal.setTimeInMillis(this.horaireArrivee);
		Date laDate = leCal.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leBillet += MSGDATE + leJour.format(laDate) + "\n";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leBillet += MSGHEURE + lHeure.format(laDate) + "\n";

		return leBillet;
	}

	public String afficheTicket() {
		final String MSGNOM = "Complexe ";
		final String MSGNUM = "Ticket de sortie n° : ";
		final String MSGDATE = "Date : ";
		final String MSGHEURE = "Heure : ";
		final String MSGCOUT = "Montant : ";

		String leTicket;

		leTicket = MSGNOM + this.getComplexe().getNomComplexe() + "\t";
		leTicket += MSGNUM + ++Arrivee.numeroSortie + "\n";

		this.hDep = Calendar.getInstance();
		
		//on simule ici une sortie 32 mn plus tard
		hDep.add(Calendar.MINUTE, +32);
		
		Date laDate = hDep.getTime();
		SimpleDateFormat leJour = new SimpleDateFormat("dd/MM/yyyy");
		leTicket += MSGDATE + leJour.format(laDate) + "\n";
		SimpleDateFormat lHeure = new SimpleDateFormat("HH:mm");
		leTicket += MSGHEURE + lHeure.format(laDate) + "\n";
		leTicket += MSGCOUT + this.getMontant() + " €\n";

		return leTicket;
	}

	public double getMontant() {
		double cout = 0;

		if (hDep != null) {
			// on passe des ms en mn
			long dep = hDep.getTimeInMillis() / (1000 * 60);
			long arr = this.horaireArrivee / (1000 * 60);
			long duree =  dep - arr;
			

			if (duree <= 30 && duree > 15) {
				cout = 0.5;
			} else {
				if (duree < 60) {
					cout = 1;
				} else {
					// cout fixe d'une heure
					cout = 1;
					duree -= 60;
					// + tous les 1/4 h commencés
					long nbquarts, reste;
					nbquarts = duree / 15;
					reste = duree % 15;
					if (reste != 0)
						nbquarts++;
					cout += nbquarts * 0.5;
				}

			}
		}
		return cout;
	}

	public Complexe getComplexe() {
		return this.complexe;
	}

	public void setNumeroArrivee(int numero) {
		numeroArrivee = numero;
	}
}
