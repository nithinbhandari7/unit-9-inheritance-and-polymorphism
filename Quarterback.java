public class Quarterback extends FantasyFootballPlayer{
	public Quarterback(String n) {
		super(n);
	}
	
	public void score(double score, int touchdowns, int yards) {
		super.score(touchdowns * 4, 0, 0);
		super.score(((int)(((yards/25.0) * 10) + 0.5))/10.0, 0, 0);
	}
}