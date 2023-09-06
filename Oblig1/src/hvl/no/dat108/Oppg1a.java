package hvl.no.dat108;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppg1a {

	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
			
		Collections.sort(listen,(str1, str2) -> Integer.parseInt(str1) - Integer.parseInt(str2));
		
        System.out.print("Sortert liste: " + listen);
		
	}

}

