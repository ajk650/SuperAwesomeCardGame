package application.model;

public class Player {
	private String name;
	private String score;

	public Player() {
		this.name = "";
		this.score = "";
	}

	public Player(String name, String score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
