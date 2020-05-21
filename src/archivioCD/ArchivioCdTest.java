package archivioCD;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArchivioCdTest {
	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.Add_Cd_test(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.Add_Cd_test(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.Insert_Num_Cd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.Add_Cd_test(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.Add_Cd_test(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertTrue(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.Add_Cd_test(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.Add_Cd_test(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertFalse(archivio.contiene("La buona novella"));
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCd archivio = new ArchivioCd();
		archivio.Add_Cd_test(new Cd("Anime salve", "Fabrizio De Andrè"));
		archivio.Add_Cd_test(new Cd("Storia di un impiegato", "Fabrizio De Andrè"));
		assertEquals(2, archivio.Insert_Num_Cd());
		archivio.eliminaCd("Anime salve");
		assertEquals(1, archivio.Insert_Num_Cd());
		assertFalse(archivio.contiene("Anime salve"));
	}
}
