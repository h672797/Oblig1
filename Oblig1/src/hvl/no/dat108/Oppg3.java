package hvl.no.dat108;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Thora", "Merathe", Kjonn.KVINNE, "Sjef", 1000000),
				new Ansatt("Sylvia", "Anders", Kjonn.KVINNE, "Designer", 500000),
				new Ansatt("Hallstein", "Anton", Kjonn.MANN, "Vaskehjelp", 450000),
				new Ansatt("Halvor", "Hanna", Kjonn.MANN, "Utvikler", 600000),
				new Ansatt("Kristen", "Marie", Kjonn.KVINNE, "HR", 650000)
				);
		
		List<String> etternavn = ansatte.stream() 
				.map(a -> a.getEtternavn())
				.collect(Collectors.toList());
				System.out.println("a) Liste med etternavn: " + etternavn);
				
		long antall = ansatte.stream()
				.filter(b -> b.getKjonn() == Kjonn.KVINNE)
				.count();
				System.out.println("b) Antall kvinner = " + antall);
	

		 double gjlonn = ansatte.stream()
				 .filter(c -> c.getKjonn() == Kjonn.KVINNE)
				 .mapToDouble(Ansatt::getAarslonn)
				 .average()
				 .getAsDouble();
		 		System.out.println("c) Gjennomsnittlønn til kvinner = " + gjlonn);
		 	
		 List<Ansatt> lonnsokning = ansatte.stream()
				 .filter(d -> d.getStilling().contains("Sjef"))
				 .collect(Collectors.toList());
				 lonnsokning.stream().forEach(d -> {d.setAarslonn(d.getAarslonn() + ((d.getAarslonn() * 7 / 100)));
				 skrivUtAlle(ansatte);
				 });
				 
		boolean merEnn = ansatte.stream()
				.anyMatch(e -> e.getAarslonn() > 800000);
				System.out.println("e) Er det noen som tjener mer enn 800 000kr? " + merEnn);
				
		
		System.out.println("f) System.out.println uten løkke" + "\n");
				ansatte.stream().forEach(System.out::println);
			
		Ansatt minLonn = ansatte.stream()
				.min(Comparator.comparing(Ansatt::getAarslonn))
				.orElseThrow(NoSuchElementException::new);
		
				System.out.println("g) Den ansatt som har lavest lønn: " + minLonn);
		
		int summen = IntStream.range(0,1000)	
				.filter(g -> g % 3 == 0 || g % 5 == 0)
				.reduce(0, (sum, tall) -> sum + tall);
				System.out.println("g) Summen av heltall i [1, 1000] / 3||5 er " + summen);
			
	}	
	
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		System.out.println("d) Ny liste med lønnsøkning");
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}
		System.out.println();
	}
}


