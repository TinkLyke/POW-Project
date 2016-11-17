package pow_interface;

import java.util.ArrayList;

//perform binary search 
public class searchDeadbird {

	public static double searchBird(String key, ArrayList<Deadbird> deadBirds) {
		double numerator = 0.0;
		double denominator = 0.0;
		double powRating = 0.0;
		int lo = 0;
		int hi = deadBirds.size() - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key.compareTo(deadBirds.get(mid).getName()) < 0)
				hi = mid - 1;
			else if (key.compareTo(deadBirds.get(mid).getName()) > 0)
				lo = mid + 1;
			else {
				int startIndex = mid - 1;
				int endIndex = mid + 1;

				while (deadBirds.get(startIndex).getName().equals(key)) {
					startIndex -= 1;
					if (startIndex > 13897 || startIndex < 0) {
						break;
					}
				}
				startIndex += 1;

				while (deadBirds.get(endIndex).getName().equals(key)) {
					endIndex += 1;
					if (endIndex > 13897 || endIndex < 0) {
						break;
					}
				}
				endIndex += -1;

				for (int i = startIndex; i < endIndex; i++) {
					numerator += (deadBirds.get(mid).getProbInc() * 100) * (deadBirds.get(mid).getReliability());
					denominator += deadBirds.get(mid).getReliability();
				}
				powRating = numerator / denominator;
				return powRating;
			}
		}
		return -1;
	}
}
