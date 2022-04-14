public class RunningBack extends FantasyFootballPlayer{
	public RunningBack(String n) {
		super(n);
	}
	
	public void score(double score, int touchdowns, int yards) {
		super.score(touchdowns * 6, 0, 0);
		super.score(((int)(((yards/10.0) * 10) + 0.5))/10.0, 0, 0);
	}
}