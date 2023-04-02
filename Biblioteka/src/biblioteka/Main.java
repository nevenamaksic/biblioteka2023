package biblioteka;

public class Main {

	public static void main(String[] args) {

		Biblioteka biblioteka = new Biblioteka();
		Knjiga k = new Knjiga();
		k.setAutori(null);
		k.setIsbn(1);
		k.setIzdanje(1);
		k.setIzdavac("Laguna");
		k.setNaslov("Orlovi rano lete");

		biblioteka.dodajKnjigu(k);
		biblioteka.pronadjiKnjigu(null, k.getIsbn(), k.getNaslov(), k.getIzdavac(), "knjigeToJson.json");

	}

}
