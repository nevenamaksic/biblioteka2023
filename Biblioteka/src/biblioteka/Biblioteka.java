package biblioteka;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private List<Knjiga> knjige = new ArrayList<Knjiga>();
	
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");

		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga je duplikat");

		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn < 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu");

		List<Knjiga> rezultati = new ArrayList<Knjiga>();

		if (naslov != null)
			for (Knjiga k : knjige)
				if (k.getNaslov().toLowerCase().contains(naslov.toLowerCase().trim()))
					rezultati.add(k);

		return rezultati;
	}

	@Override
	public void upisUJsonFormatu(String putanja) throws IOException {
			try (FileWriter out = new FileWriter(putanja)) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				out.write(gson.toJson(knjige));
			}

	}

	@Override
	public void ucitajJsonFormatUBiblioteku(String putanja) throws IOException {
		try (FileReader in = new FileReader(putanja)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			List<Knjiga> noveKnjige = Arrays.asList(gson.fromJson(in, Knjiga[].class));
			
			for (Knjiga knjiga : noveKnjige) {
				if(knjige.contains(knjiga)) {
					continue;
				}
				else {
					knjige.add(knjiga);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}