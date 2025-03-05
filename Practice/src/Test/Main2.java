package Test;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class Main2 {

	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<>();
		hm.put("NIT", "Ameerpet");
		hm.put(new String("NIT"), "Hyderabad");
		System.out.println(hm.size());
		System.out.println(hm);
		
		System.out.println("........................");
		
		IdentityHashMap<String,String> ihm = new IdentityHashMap<>();
		ihm.put("NIT", "Ameerpet");
		ihm.put(new String("NIT"), "Hyderabad");
		System.out.println(ihm.size());
		System.out.println(ihm);

	}

}
