
public class Score{

	public int score;
	public long startTime;
	public long endTime;
	public long sumTime;
	
	public Score() {
		score = 0;
	}
	
	public int getScoreValue() {
		return score;
	}
	
	public void setScoreValue(int score) {
		this.score = score;
	}
	
	public void resetScore() {
		score = 0;
		sumTime = 0;
		startTime = 0;
		endTime = 0;
	}
	
	public void startTime() {
		startTime = System.currentTimeMillis();
	}
	
	public void pauseTime() {
		endTime = System.currentTimeMillis();
		sumTime = sumTime + endTime - startTime;
	}
	
	public double getTime() {
		endTime = System.currentTimeMillis();
		sumTime = sumTime + endTime - startTime;
		return (double)sumTime/(double)1000;
		
	}
	
}
