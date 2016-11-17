package pow_interface;

import java.util.ArrayList;

public class graphAreas {

	public static String[][] searchLocations(String key, ArrayList<Deadbird> db) {

		ArrayList<ArrayList<String>> use = new ArrayList<ArrayList<String>>();
		use.add(new ArrayList<String>());
		use.add(new ArrayList<String>());

		String prevBird = "";
		int first = 0;
		
		for (Deadbird d : db) {
			if (d.getLocation().equals(key)) {
				if(first == 0){
					first++;
					prevBird = d.getName();
					use.get(0).add(d.getName());
					use.get(1).add(String.valueOf(d.getTrend()));
				}
				else if(!prevBird.equals(d.getName())){
					prevBird = d.getName();
					use.get(0).add(d.getName());
					use.get(1).add(String.valueOf(d.getTrend()));
				}
			}
		}
		use.get(0).add(key);
		
		return listToArray(use);
	}

	private static String[][] listToArray(ArrayList<ArrayList<String>> c) {

		String[][] a = new String[c.size()][c.get(0).size()];
		for (int i = 0; i < c.size(); i++) {
			for (int j = 0; j < c.get(1).size(); j++) {
				a[i][j] = c.get(i).get(j);
			}
		}
		a[0][c.get(0).size()-1] = c.get(0).get(c.get(0).size()-1);
		return a;
	}
}
