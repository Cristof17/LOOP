package eroi;

public abstract class Hero {
	
	public int level;
	public int XP;
	public int HP;
	public int maxHP;
	public int damageOverTimeRounds = 0;
	
	public int increaseHP(int value ){
		return 0;
	}
	
	public int decreaseHP(int value){
		this.HP -= value ;
		if(this.HP < 0 ){
			this.HP = 0;
		}
		return this.HP;
	}
	
	public int increaseXP(){
		return 0;
	}
	
	public int decreaseXP(){
		return 0;
	}
	
	public int increaseLevel(int value){
		return 0;
	}
	
	public int decreaseLevel(int value){
		return 0;
		
	}
	
	public void takeDamageOverTime(int damage ,int rounds ){
		decreaseHP(damage);
		this.damageOverTimeRounds = rounds ;
	}
	
	public void decreaseDamageOverTimeRounds(){
		damageOverTimeRounds --;
	}
	
	public boolean isDead(){
		return HP <= 0 ;
	}
	
	public void wins(Hero enemy){
		this.HP = maxHP;
		calculateLevel(enemy);
	}
	
	public void calculateLevel(Hero loser){
		this.XP = loser.XP + Math.max(0, 200 - (this.level - loser.level ) *40);
	}
	
	
	
	
}
