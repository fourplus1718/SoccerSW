package settings;

public class Settings {

	public String league;
	public int year;
	public float basic;
	public float poisson;
	public float weightedPoisson;
	public float htCombo;
	public float shots;
	public float similars;
	public float similarsPoisson;
	public float halfTimeOverOne;
	public float threshold;
	public float upperBound;
	public float lowerBound;
	public float successRate;
	public float profit;
	public float minUnder;
	public float maxUnder;
	public float minOver;
	public float maxOver;
	public float value;

	public Settings(String league, float basic, float poisson, float weightedPoisson, float threshold, float upperBound,
			float lowerBound, float successRate, float profit) {
		this.league = league;
		this.basic = basic;
		this.poisson = poisson;
		this.weightedPoisson = weightedPoisson;
		this.threshold = threshold;
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		this.successRate = successRate;
		this.profit = profit;
		this.minUnder = 1.3f;
		this.maxUnder = 10f;
		this.minOver = 1.3f;
		this.maxOver = 10f;
	}

	public Settings(Settings other) {
		this.league = other.league;
		this.year = other.year;
		this.basic = other.basic;
		this.poisson = other.poisson;
		this.weightedPoisson = other.weightedPoisson;
		this.halfTimeOverOne = other.halfTimeOverOne;
		this.htCombo = other.htCombo;
		this.threshold = other.threshold;
		this.upperBound = other.upperBound;
		this.lowerBound = other.lowerBound;
		this.successRate = other.successRate;
		this.profit = other.profit;
		this.value = other.value;
		this.minUnder = other.minUnder;
		this.maxUnder = other.maxUnder;
		this.minOver = other.minOver;
		this.maxOver = other.maxOver;
	}

	public Settings withYear(int year) {
		this.year = year;
		return this;
	}

	public Settings withHT(float overOne, float htCombo) {
		this.halfTimeOverOne = overOne;
		this.htCombo = htCombo;
		return this;
	}

	public Settings withShots(float shots) {
		this.shots = shots;
		return this;
	}

	public Settings withSimilars(float similars) {
		this.similars = similars;
		return this;
	}

	public Settings withSimilarPoissons(float similars) {
		this.similarsPoisson = similars;
		return this;
	}

	public Settings withValue(float value) {
		this.value = value;
		return this;
	}

	public Settings withMinMax(float minUnder, float maxUnder, float minOver, float maxOver) {
		this.minUnder = minUnder;
		this.maxUnder = maxUnder;
		this.minOver = minOver;
		this.maxOver = maxOver;
		return this;
	}

	public Settings withTHandBounds(float f) {
		this.threshold = f;
		this.lowerBound = f;
		this.upperBound = f;
		return this;
	}

	public static Settings shots(String league) {
		return new Settings(league, 0f, 0f, 0f, 0.55f, 0.55f, 0.55f, 0.5f, 0f).withShots(1f);
	}

	public static Settings basic(String league) {
		return new Settings(league, 1f, 0f, 0f, 0.55f, 0.55f, 0.55f, 0.5f, 0f);
	}

	public static Settings poisson(String league) {
		return new Settings(league, 0f, 1f, 0f, 0.55f, 0.55f, 0.55f, 0.5f, 0f);
	}

	public static Settings weightedPoisson(String league) {
		return new Settings(league, 0f, 0f, 1f, 0.55f, 0.55f, 0.55f, 0.5f, 0f);
	}

	public static Settings halfTime(String league, float overOne) {
		return new Settings(league, 0f, 0f, 0f, 0.55f, 0.55f, 0.55f, 0.5f, 0f).withHT(overOne, 1f);
	}

	@Override
	public String toString() {
		return league + " bas*" + format(basic) + " poi*" + format(poisson) + " wei*" + format(weightedPoisson) + " ht*"
				+ format(htCombo) + " under " + format(minUnder) + "-" + format(maxUnder) + " over " + format(minOver)
				+ "-" + format(maxOver) + " thold "
				+ format(threshold) /*
									 * + " lower " + format(lowerBound) +
									 * " upper " + format(upperBound)
									 */ + " value " + format(value) + String.format(" %.2f%% ", successRate * 100)
				+ format(profit);

	}

	private String format(float d) {
		return String.format("%.2f", d);
	}

}
