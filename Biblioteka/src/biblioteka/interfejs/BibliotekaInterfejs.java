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

	/**
	 * Ucitava sve knjige iz json fajla i unosi ih u biblioteku.
	 * 
	 * Knjige se dodaju na vec postojece knjige u biblioteci.
	 * 
	 * Dodaju se samo knjige koje vec ne postoje u biblioteci.
	 * 
	 * @param putanja putanjda do json fajla iz kog se ucitavaju knjige
	 * @throws IOException u slucaju greske prilikom ucitavanja iz fajla
	 */
	public void ucitajJsonFormatUBiblioteku(String putanja) throws IOException;

	/**
	 * Pronalazi knjige iz biblioteke i upisuje u fajl u JSON formatu.
	 * 
	 * Upis je u pretty print formatu i ukljucuje i null vrednosti.
	 * 
	 * @param autor   autor knjige
	 * @param isbn    isbn - medjunarodni standardni knjizni broj
	 * @param naslov  naslov knjige
	 * @param izdavac izdavac knjige
	 * @param putanja putanja do fajla u koji se upisuju rezultati pretrage
	 */
	public void pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac, String putanja);
}
