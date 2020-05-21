package archivioCD;

import java.util.*;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Cd {

	private String titolo;
	private String autore;

	private final static String DESCRIZIONE_CD = "Titolo: %s, Autore: %s, Lista dei brani: %s";

	private ArrayList<Brano> listaBrani = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	public Cd(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
		listaBrani = new ArrayList<Brano>();
	}

	public void aggiungiBrano(Brano brano) {

		listaBrani.add(brano);
	}

	public String getTitolo() {
		return titolo;
	}

	public boolean matchTitolo(String cercato) {
		return titolo.equalsIgnoreCase(cercato);
	}

	public Brano branoCasuale() {
		int estratto = EstrazioniCasuali.estraiIntero(0, listaBrani.size() - 1);
		return listaBrani.get(estratto);
	}

	public String toString() {

		StringBuffer risultato = new StringBuffer();

		StringBuffer brani = new StringBuffer();
		for (int i = 0; i < listaBrani.size(); ++i) {
			Brano brano = (Brano) listaBrani.get(i);
			brani.append(brano.toString());
		}
		risultato.append(String.format(DESCRIZIONE_CD, titolo, autore, brani));

		return risultato.toString();
	}

}
