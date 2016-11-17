package pow_interface;

import java.util.ArrayList;

public class graphDeadBirds {

	public static String[][] searchBirds(String key, ArrayList<Deadbird> deadBirds) {

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

				String[][] array = new String[2][endIndex - startIndex + 1];

				for (int i = 0; i < endIndex - startIndex; i++) {

					for (int j = 0; j < 2; j++) {

						if (j == 0)
							array[j][i] = deadBirds.get(i + startIndex + 1).getLocation();
						else
							array[j][i] = Double.toString(deadBirds.get(i + startIndex + 1).getTrend());
					}

				}
				array[0][endIndex - startIndex] = deadBirds.get(startIndex).getName();

				return array;
			}
		}
		return new String[0][0];
	}
}
