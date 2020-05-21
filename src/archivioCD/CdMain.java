package archivioCD;

import java.util.Scanner;

public class CdMain {

	private final static String MESS_BENVENUTO = "\nBENVENUTO NEL PROGRAMMA ARCHIVIO CD\n";
	private final static String MENU_SCELTA = "1.Inserisci i CD\n2.Visualizza i CD esistenti\n3.Rimozione di un CD\n4.Visualizione di tutta la libreria\n5.Selezione Casuale di un brano\n0.Esci dal programma";
	// private final static String MESS_INSERT_CD = "Quanti CD vuoi inserire?";

	private final static String MESS_ERROR_MENU = "La funzione selezionata non è disponibile , scegliere tra quelle del menù.";
	private final static String MESS_TERMINE = "IL PROGRAMMA è TERMINATO, ARRIVEDERCI!";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArchivioCd archivio = new ArchivioCd();

		Scanner sc = new Scanner(System.in);

		int scelta = 0;

		do {

			System.out.println(MESS_BENVENUTO);
			System.out.println(MENU_SCELTA);

			scelta = sc.nextInt();

			switch (scelta) {
			case 0:
				System.out.println("MESS_TERMINA");
				break;
			case 1:

				// inserisci cd

				archivio.insertCd();

				/*
				 * variante inserimento cd nel main
				 * 
				 * System.out.println(MESS_INSERT_CD); numCd = sc.nextInt();
				 * 
				 * inserisci numero di cd
				 * 
				 * for (int i = 0; i < numCd; i++) {
				 * 
				 * inserisci cd archivio.insertCd();
				 * 
				 * }
				 */
				break;

			case 2:
				// visualizzare il cd

				archivio.visualizerCD();

				break;

			case 3:
				// rimozione cd

				archivio.deleteCD();

				break;

			case 4:
				// visualizza tostring

				System.out.println(archivio.toString());

				break;

			case 5:
				// brano_Random

				archivio.selezioneCasuale();

				break;

			default:

				System.out.println(MESS_ERROR_MENU);

				break;
			}
		} while (scelta != 0);

	}

}
