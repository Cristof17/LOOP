package main;
/**
 * 
 * @author cristof
 * This class is the base class for every 
 * character . It contains the basic
 * attributes of characters like HP and XP 
 * and also methods for checking the state
 * of a character
 */

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
	
	/**
	 * 
	 * This method is overridden by all the
	 * children of the Hero class 
	 */
	public void damages(Hero h ,int field , int round){
		h.isDamagedBy(this, field, round);
	}
	/**
	 * 
	 * @param h The hero that this hero 
	 * @param field
	 * @param round
	 */
	public void isDamagedBy(Hero h , int field , int round ){
		
	}
	
	public void isDamagedBy(Pyromancer p , int field ,int round ){
		
	}
	/**
	 * 
	 * @param w The wizard that attacks the hero
	 * @param field The field where the fight takes place
	 * @param round
	 */
	public void isDamagedBy(Wizard w ,int field ,int round){
		
	}
	/**
	 * 
	 * @param k The knight that attacks the hero
	 * @param field The field where the fight takes place
	 * @param round
	 */
	public void isDamagedBy(Knight k ,int field ,int round){
		
	}
	
	/**
	 * 
	 * @param r The rogue that attacks the hero
	 * @param field The field where the fight takes place
	 * @param round
	 */
	public void isDamagedBy(Rogue r, int field, int round){
		
	}
	
	
	/**
	 * 
	 * @param value The decrease value of the HP
	 * @return HP Increased HP
	 */
	public int decreaseHP(int value){
		this.HP -= value ;
		if(this.HP < 0 ){
			this.HP = 0;
		}
		return this.HP;
	}
	
	/**
	 * 
	 * @return Level that got increased
	 */
	public int increaseLevel(){
		if(this.XP >= 250 + this.level *50 ){
			this.level++;
		}
	return this.level;
	}
	
	/**
	 * 
	 * @param damage Damage that the hero takes every round
	 * @param rounds Number of rounds that the hero must take damage
	 * @param incapacitate If the hero must not move a round this is set to true
	 */
	public void setDamageOverTime(int damage ,int rounds ,boolean incapacitate){
		this.damageOverTime = damage ;
		this.damageOverTimeRounds = rounds ;
		this.incapacitate = incapacitate;
	}
	
	/**
	 * 
	 */
	public void takeDamageOverTime(){
		if(damageOverTimeRounds > 0){
			decreaseHP(damageOverTime);
			damageOverTimeRounds--;
		}
	}
	/**
	 * 
	 */
	public void decreaseDamageOverTimeRounds(){
		damageOverTimeRounds --;
	}
	
	/**
	 * 
	 * @return Returns true if the HP is below 0 or equal to 0
	 */
	public boolean isDead(){
		return HP <= 0 ;
	}
	
	/**
	 * 
	 * @return Returns true if the hero cannot move this round
	 */
	public boolean isIncapacitated(){
		return this.incapacitate;
	}
	
}
