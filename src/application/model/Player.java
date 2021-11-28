package application.model;

public class Player {
	// each player will have a name and a score
	// to be used in the leaderboard
	private String name;
	private String score;

	public Player() {
		this.name = "";
		this.score = "";
	}

	// Player class constructor
	public Player(String name, String score) {
		this.name = name;
		this.score = score;
	}

	// return String name
	public String getName() {
		return name;
	}

	// set current object name
	public void setName(String name) {
		this.name = name;
	}

	// returns score
	public int getScore() {
		return Integer.parseInt(score);
	}

	// changes score of current object
	public void setScore(String score) {
		this.score = score;
	}

}
