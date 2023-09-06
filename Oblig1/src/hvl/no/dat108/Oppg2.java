package hvl.no.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
			new Ansatt("Thora", "Merathe", Kjonn.KVINNE, "Sjef", 1000000),
			new Ansatt("Sylvia", "Anders", Kjonn.KVINNE, "Designer", 500000),
			new Ansatt("Hallstein", "Anton", Kjonn.MANN, "Vaskehjelp", 450000),
			new Ansatt("Halvor", "Hanna", Kjonn.MANN, "Utvikler", 600000),
			new Ansatt("Kristen", "Marie", Kjonn.KVINNE, "HR", 650000)
			);
		
		int fastKrone = 1000;
		int fastProsent = 10;
		int lavLonnGrense = 460000;
		int lavLonnTillegg = 50000;
		int mannTillegg = 19;
			
		lonnsoppgjor(ansatte, a -> a.getAarslonn() + fastKrone);
			System.out.println("Hvordan lønnen endres etter et fast kronetillegg: ");
			skrivUtAlle(ansatte);
			
		lonnsoppgjor(ansatte, a -> a.getAarslonn() + (fastProsent * a.getAarslonn() / 100));
			System.out.println("Hvordan lønnen endrer seg etter et past prosenttillegg: ");
			skrivUtAlle(ansatte);
		
		lonnsoppgjor(ansatte, a -> {
			if (a.getAarslonn() < lavLonnGrense) {
				return a.getAarslonn() + lavLonnTillegg;
			} else {
				return a.getAarslonn();
			}
		});
			System.out.println("Hvordan lønnen endrer seg etter et fast kronetillegg hvis du har lav lønn: ");
			skrivUtAlle(ansatte);
			
		lonnsoppgjor(ansatte, a -> {
			if(a.getKjonn() == Kjonn.MANN) {
				return a.getAarslonn() + mannTillegg;
			} else {
				return a.getAarslonn();
			}
		});
			System.out.println("Hvordan lønnen endrer seg etter et fast prosenttillegg hvis du er mann: ");
			skrivUtAlle(ansatte);
			
		

	}
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
			for (Ansatt a : ansatte) {
				a.setAarslonn(funksjon.apply(a));
			}
		}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		System.out.println();
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}
		System.out.println();
	}
}
