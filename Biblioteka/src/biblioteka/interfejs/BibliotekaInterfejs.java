package biblioteka.interfejs;

import java.io.IOException;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterfejs {

	public void dodajKnjigu(Knjiga knjiga);

	public void obrisiKnjigu(Knjiga knjiga);

	public List<Knjiga> vratiSveKnjige();

	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac);

	/**
	 * Upisuje sve knjige iz biblioteke u fajl u JSON formatu.
	 * 
	 * Upis je u pretty print formatu.
	 * 
	 * @param putanja putanja do json fajla u koji se upisuju knjige
	 * 
	 * @throws IOException u slucaju greske prilikom upisa u fajl
	 */
	public void upisUJsonFormatu(String putanja) throws IOException;
}
