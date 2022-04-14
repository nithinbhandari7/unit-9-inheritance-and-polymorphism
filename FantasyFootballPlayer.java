public class FantasyFootballPlayer {
	private String name;
	private double points = 0;
	
	public FantasyFootballPlayer(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPoints() {
		return points;
	}
	
	public String toString() {
		return name + " has " + points + " fantasy points";
	}
	
	public void score(double score, int touchdowns, int yards) {
		points += score;
	}
}