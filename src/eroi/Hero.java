package eroi;


public abstract class Hero  { 
	
	public int level;
	public int XP;
	public int HP;
	public int maxHP;
	public int damageOverTimeRounds = 0;
	public int damageOverTime = 0 ;
	public boolean incapacitate ;
	public int x;
	public int y;
	
	
	public void damages(Hero h ,int field , int round){
		h.isDamagedBy(this, field, round);
	}
	
	public void isDamagedBy(Hero h , int field , int round ){
		
	}
	
	public void isDamagedBy(Pyromancer p , int field ,int round ){
		
	}
	
	public void isDamagedBy(Wizard w ,int field ,int round){
		
	}
	
	public void isDamagedBy(Knight k ,int field ,int round){
		
	}
	
	public void isDamagedBy(Rogue r, int field, int round){
		
	}
	
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
	
	
	public void setDamageOverTime(int damage ,int rounds ,boolean incapacitate){
		this.damageOverTime = damage ;
		this.damageOverTimeRounds = rounds ;
		this.incapacitate = incapacitate;
	}
	
	public void takeDamageOverTime(){
		if(damageOverTimeRounds > 0){
			decreaseHP(damageOverTime);
			damageOverTimeRounds--;
		}
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
	
	public boolean isIncapacitated(){
		return this.incapacitate;
	}
	
}
