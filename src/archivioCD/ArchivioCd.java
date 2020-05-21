package archivioCD;

import it.unibs.fp.mylib.*;

import java.util.*;

public class ArchivioCd {

//STRINGHE OUTPUT

	private final static String MEX_INSERT_TITOLOCD = "Inserisci il titolo del CD:  ";
	private final static String MEX_INSERT_AUTORE = "Inserisci l'autore del CD: ";
	private final static String MEX_INSERT_TITOLO = "Inserisci il titolo del brano:  ";
	private final static String MEX_BRANO_N = "Brano n.";
	private final static String MEX_INSERT_BRANO_DURATA = "Inserisci la durata del brano in secondi: ";
	private final static String MEX_STARTINSERTBRANO = "Inserimento dei brani del CD:";
	private final static String MEX_QUESTION_BRANO = "Vuoi inserire un altro brano?";

	private final static String MEX_CDSEARCH = "Inserisci il titolo del CD: ";
	private final static String MEX_DELETECD = " : confermi di voler eliminare questo cd dalla tua libreria?";
	private final static String MEX_CDNOTFOUND = "Il CD cercato non è presente nella libreria";
	private final static String MEX_RANDOMBRANO = "Il brano estratto in forma aleatoria e' ";
	private final static String MEX_ERROR = "Il cd è già presente nella libreria, inserirne un altro.";

	private final static String MEX_EMPTYARCHIVE = "L'archivio risulta vuoto";
	private final static String MEX_INFOCD = "%n CD n %d DELLA COLLEZIONE%n";

	private final static int MINIMUM_SEC = 1;

//Arraylist ARCHIVIO CD

	private ArrayList<Cd> ArrayCD;

	public ArchivioCd() {
		ArrayCD = new ArrayList<>();
	}

	public void insertCd() {
		String titolocd = InputDati.leggiStringaNonVuota(MEX_INSERT_TITOLOCD);

		if (searchCD(titolocd) != null)
			System.out.println(MEX_ERROR);
		else {

			String autorecd = InputDati.leggiStringaNonVuota(MEX_INSERT_AUTORE);

			Cd cd = new Cd(titolocd, autorecd);

			System.out.println("\n");
			System.out.println(MEX_STARTINSERTBRANO + titolocd);

			int count = 1;

			do {
				System.out.println(MEX_BRANO_N + count);

				String titolobrano = InputDati.leggiStringaNonVuota(MEX_INSERT_TITOLO);

				int duratabrano = InputDati.leggiInteroConMinimo(MEX_INSERT_BRANO_DURATA, MINIMUM_SEC);

				Brano b = new Brano(titolobrano, duratabrano);

				cd.aggiungiBrano(b);

				count++;

			} while (InputDati.yesOrNo(MEX_QUESTION_BRANO));

			ArrayCD.add(cd);
		} // chiusura else

	}

	public void deleteCD() {

		Cd elemento = searchCD();

		if (elemento != null) {
			boolean procedi = InputDati.yesOrNo(elemento.getTitolo() + MEX_DELETECD);
			if (procedi)
				ArrayCD.remove(elemento);
		} else
			System.out.println(MEX_CDNOTFOUND);
	}

	private Cd searchCD() {
		String searchcdtitle = InputDati.leggiStringaNonVuota(MEX_CDSEARCH);

		return searchCD(searchcdtitle);
	}

	public Cd searchCD(String searchcdtitle) {
		Cd elemento = null;

		for (int i = 0; i < ArrayCD.size(); i++) {

			elemento = ArrayCD.get(i);

			if (elemento.matchTitolo(searchcdtitle))// DA CONTROLLARE IN CD.java

				return elemento;
		}
		return null;
	}

	public void visualizerCD() {

		Cd elemento = searchCD();

		if (elemento != null) {
			System.out.println(elemento.toString());
		} else {
			System.out.println(MEX_CDNOTFOUND);
		}

	}

	public void selezioneCasuale() {
		if (ArrayCD.size() == 0)
			System.out.println(MEX_EMPTYARCHIVE);
		else {
			int numCD = ArrayCD.size();
			int estratto = EstrazioniCasuali.estraiIntero(0, numCD - 1);

			Cd selCD = ArrayCD.get(estratto);

			Brano selBrano = selCD.branoCasuale(); // DA CONTROLLARE IN CD

			System.out.print(MEX_RANDOMBRANO);
			System.out.println(selBrano.toString());
		}

	}

	public String toString() {

		if (ArrayCD.size() == 0)
			return MEX_EMPTYARCHIVE;
		else {
			StringBuffer risultato = new StringBuffer();
			for (int i = 0; i < ArrayCD.size(); i++) {
				risultato.append(String.format(MEX_INFOCD, i + 1));
				Cd elemento = ArrayCD.get(i);
				risultato.append(elemento.toString());
			}
			return risultato.toString();
		}
	}

	public void Add_Cd_test(Cd cd) {
		ArrayCD.add(cd);
	}

	public boolean contiene(String searchcdtitle) {
		return searchCD(searchcdtitle) != null;
	}

	public int Insert_Num_Cd() {
		return ArrayCD.size();
	}

	public void eliminaCd(String titolo) {
		Cd cd = searchCD(titolo);
		if (cd != null)
			this.eliminaCd(cd);
	}

	public void eliminaCd(Cd cd) {
		ArrayCD.remove(cd);
	}

}