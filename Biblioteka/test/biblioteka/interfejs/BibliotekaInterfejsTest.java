package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import biblioteka.Autor;
import biblioteka.Biblioteka;
import biblioteka.Knjiga;

public abstract class BibliotekaInterfejsTest {

	Biblioteka biblioteka;

	@BeforeEach
	void setUp() throws Exception {
		biblioteka = new Biblioteka();
	}

	@AfterEach
	void tearDown() throws Exception {
		biblioteka = null;
	}

	@ParameterizedTest
	@ValueSource(strings = { "knjige.json" })
	void testUpisUJsonFormatu(String input) {

		try (FileReader in = new FileReader(input)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			List<Knjiga> knjige = Arrays.asList(gson.fromJson(in, Knjiga[].class));

			List<Autor> autori = new ArrayList<>();
			Biblioteka biblioteka = new Biblioteka();

			Knjiga knjiga = new Knjiga();
			Autor autor = new Autor();

			autor.setIme("Nevena");
			autor.setPrezime("Maksic");
			autori.add(autor);

			knjiga.setIsbn(1);
			knjiga.setIzdanje(2);
			knjiga.setIzdavac("Vulkan");
			knjiga.setNaslov("Zivot Nene Maksic");
			knjiga.setAutori(autori);

			biblioteka.dodajKnjigu(knjiga);

			Knjiga knjiga1 = new Knjiga();
			Autor autor1 = new Autor();

			autor1.setIme("Miljana");
			autor1.setPrezime("Jovic");
			autori.add(autor1);

			knjiga1.setIsbn(2);
			knjiga1.setIzdanje(2);
			knjiga1.setIzdavac("Mikro knjiga");
			knjiga1.setNaslov("Osnove programskog jezika C");
			knjiga1.setAutori(autori);

			biblioteka.dodajKnjigu(knjiga1);

			List<Knjiga> novaLista = biblioteka.vratiSveKnjige();

			assertEquals(novaLista, knjige);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
