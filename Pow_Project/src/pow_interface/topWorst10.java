package pow_interface;

import pow_interface.Merge;
import java.util.ArrayList;

public class topWorst10 {
	public static powRating[] SortPOW(ArrayList<Deadbird> db) {

		String name = "";
		double rating = 0;
		int index = 0;

		// get distinct number of birds
		String prevName1 = "";
		int count = 0;
		for (Deadbird d : db) {
			if (!prevName1.equals(d.getName())) {
				prevName1 = d.getName();
				count++;
			}
		}
		powRating[] powArray = new powRating[count];

		String prevName = "";
		for (Deadbird d : db) {
			if (!prevName.equals(d.getName())) {
				rating = searchDeadbird.searchBird(d.getName(), db);
				name = d.getName();
				powRating powAndName = new powRating(name, rating);
				powArray[index] = powAndName;
				index++;
				prevName = name;
			}
		}

		Merge.sortMerge(powArray, count);

		// worst 10 then top 10
		powRating[] pA = new powRating[20];
		for (int i = 0; i < 10; i++) {
			pA[i] = powArray[i];
		}
		int j = 1;
		for (int i = 10; i < 20; i++) {
			pA[i] = powArray[count - j];
			j++;
		}

		return pA;

	}
}
