package pow_interface;


public class Deadbird implements Comparable<Deadbird> {

	private enum Reliability {
		HIGH(3), MEDIUM(2), LOW(1);

		private int value;

		private Reliability(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	private String name;
	private String location;
	private double trend;
	private double probInc;
	private Reliability r;

	public Deadbird(String name, String location, String reliability, double trend, double probInc) {
		this.name = name;

		if (location.contains("(")) {
			String[] s = location.split(" \\(");
			if (s[0].contains("/")) {
				String[] s1 = s[0].split(" /");
				this.location = s1[0];
			} else {
				this.location = s[0];
			}
		} else {
			this.location = location;
		}
		this.trend = trend;
		this.probInc = probInc;
		if (reliability.equals("High")) {
			r = Reliability.HIGH;
		} else if (reliability.equals("Medium")) {
			r = Reliability.MEDIUM;
		} else {
			r = Reliability.LOW;
		}
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public double getTrend() {
		return trend;
	}

	public double getProbInc() {
		return probInc;
	}

	public Reliability getR() {
		return r;
	}

	public int getReliability() {
		return r.getValue();
	}

	@Override
	public int compareTo(Deadbird other) {
		if (this.getName().compareTo(other.getName()) > 0) {
			return +1;
		}
		if (this.getName().compareTo(other.getName()) < 0) {
			return -1;
		}
		return 0;
	}
}
