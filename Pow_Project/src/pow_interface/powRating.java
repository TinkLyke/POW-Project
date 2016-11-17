package pow_interface;

import java.util.ArrayList;

public class powRating implements Comparable<powRating> {

	private String name;
	private double rating;

	public powRating(String n, double POW) {

		this.name = n;
		this.rating = POW;

	}

	public double getRating() {
		return this.rating;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(powRating arg0) {
		// TODO Auto-generated method stub
		if (this.getRating() > arg0.getRating()) {
			return +1;
		}
		if (this.getRating() < arg0.getRating()) {
			return -1;
		}
		return 0;
	}
}
