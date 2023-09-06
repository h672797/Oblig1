package hvl.no.dat108;

import java.util.function.BinaryOperator;

public class Oppg1b {
	
	public static int beregn(int a, int b, BinaryOperator<Integer> funksjon) {
		int sum = funksjon.apply(a, b); 
		return sum;
		
		}

	
	public static void main(String[] args) {
		//BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> a + b;
		BinaryOperator<Integer> summerFunksjon = (a, b) -> a + b;
			int sum1 = beregn(12, 13, summerFunksjon);
			System.out.println("Summen er " + sum1);
		
		BinaryOperator<Integer> størst = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
			int sum2 = beregn(-5, 3, størst);
			System.out.println(sum2 + " er størst");
		
		BinaryOperator<Integer> avstand = (a, b) -> Math.abs(a - b);
			int sum3 = beregn(54, 45, avstand);
			System.out.println("Avstanden er " + sum3);

	}

}
