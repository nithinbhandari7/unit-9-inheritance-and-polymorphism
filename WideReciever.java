public class WideReciever extends FantasyFootballPlayer{
	public WideReciever(String n) {
		super(n);
	}
	
	public void score(double score, int touchdowns, int yards) {
		super.score(touchdowns * 6, 0, 0);
		super.score(((int)(((yards/15.0) * 10) + 0.5))/10.0, 0, 0);
	}
}
