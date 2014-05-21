package po;



import java.io.Serializable;



public class PlayerPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
    String password;
    int gameCount=0;//总局数，平均得分（玩过的所有局），最高连击数量，最高得分，单局最长无敌时间
    int avgScore=0;
    int maxHitCount=0,hitCount=0;
    int maxScore=0,score=0;
    float maxGodtime=0,godtime=0;

	public PlayerPO(String name, String password, 
			int gameCount,int avgScore,int maxHitCount,int maxScore,
			float maxGodtime) {
		this.name = name;
		this.password = password;
		this.gameCount=gameCount;
		this.avgScore=avgScore;
		this.maxHitCount=maxHitCount;
		//this.hitCount= hitCount;
		this.maxScore=maxScore;
		//this.score=score;
		this.maxGodtime=maxGodtime;
		//this.godtime=godtime;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount = gameCount;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	public int getMaxHitCount() {
		return maxHitCount;
	}

	public void setMaxHitCount(int maxHitCount) {
		this.maxHitCount = maxHitCount;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public float getMaxGodtime() {
		return maxGodtime;
	}

	public void setMaxGodtime(float maxGodtime) {
		this.maxGodtime = maxGodtime;
	}

	public float getGodtime() {
		return godtime;
	}

	public void setGodtime(float godtime) {
		this.godtime = godtime;
	}
	
	

}