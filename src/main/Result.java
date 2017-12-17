package main;

public class Result {
	public int goalsHomeTeam;
	public int goalsAwayTeam;

	public Result(int goalsHomeTeam, int goalsAwayTeam) {
		this.goalsHomeTeam = goalsHomeTeam;
		this.goalsAwayTeam = goalsAwayTeam;
	}

	/**
	 * Copy constructor
	 * 
	 * @param result
	 */
	public Result(Result result) {
		this.goalsHomeTeam = result.goalsHomeTeam;
		this.goalsAwayTeam = result.goalsAwayTeam;
	}

	public String toString() {
		return goalsHomeTeam + " : " + goalsAwayTeam;
	}

	public boolean equals(Result other) {
		return goalsAwayTeam == other.goalsAwayTeam && goalsHomeTeam == other.goalsHomeTeam;
	}
}
