package pow_interface;

import java.util.ArrayList;

public class searchArea {
	public static double searchLocation(String key, ArrayList<Deadbird> db) {
		double numerator = 0.0;
		double denominator = 0.0;
		double powRating = 0.0;

		for (Deadbird d : db) {
			if (d.getLocation().equals(key)) {
				numerator += (d.getProbInc() * 100) * (d.getReliability());
				denominator += d.getReliability();
			}
		}

		powRating = numerator / denominator;
		return powRating;
	}
}
