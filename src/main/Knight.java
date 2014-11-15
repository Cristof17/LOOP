package main;

/**
 * 
 * @author cristof
 * 
 */
public final class Knight extends Hero {

	public static final int HP_INCREMENT = 80;
	
	private static final int PYROMANCER_EXECUTE_DMG_INCREASE = 10;
	private static final int KNIGHT_EXECUTE_DMG_INCREASE = 0;
	private static final int WIZARD_EXECUTE_DMG_INCREASE = -20;
	private static final int ROGUE_EXECUTE_DMG_INCREASE = 15;
	
	private static final int PYROMANCER_SLAM_DMG_INCREASE = -10;
	private static final int KNIGHT_SLAM_DMG_INCREASE = 20;
	private static final int WIZARD_SLAM_DMG_INCREASE = 5;
	private static final int ROGUE_SLAM_DMG_INCREASE = -20;
	
	private static final int EXECUTE_BASE_DMG = 200;
	private static final int EXECUTE_LVL_INCREASE = 30;
	
	private static final int SLAM_BASE_DMG = 100;
	private static final int SLAM_LVL_INCREASE = 40;
	
	private static final int FIELD_DMG_INCREASE = 15;
	
	
	private boolean has_field_advantage = false;
	
	
	
	public Knight(){
		this.XP = 0;
		this.HP = 900;
		this.maxHP = 900;
		
	}
	
	
	public void damages(Hero h , int field , int round ){
		h.isDamagedBy(this, field, round);
	}
	
	/**
	 * @param p The Pyromancer with which the Knight fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Pyromancer p , int field , int round ){
		
		this.execute(p, field);
		this.slam(p, field);
		
		p.fireblast(this, field);
		p.ignite(this,field);
		
	}
	
	/**
	 * @param w The Wizard with which the Knight fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Wizard w ,int field ,int round ){
		
		float dmg_execute = this.execute(w, field);
		float dmg_slam = this.slam(w, field);
		
		w.drain(this, field); 
		w.deflect(this, field, dmg_execute , dmg_slam);
		
	}
	
	/**
	 * @param k The Knight with which the Knight fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Knight k , int field ,int round ){
		
		this.execute(k, field);
		this.slam(k, field);
		
		k.execute(this, field);
		k.slam(this, field);
		
	}
	
	/**
	 * @param r The Rogue with which the Knight fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Rogue r ,int field ,int round){
		
		this.execute(r, field);
		this.slam(r, field);
		
		r.backstab(this, field);
		r.paralysis(this, field);
		
	}
	
	/**
	 * This method applies Execute damage on the targeted Pyromancer
	 * 
	 * @param p Applies Execute spell on the Pyromancer
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Knight to the targeted Pyromancer
	 */
	public int execute(Pyromancer p, int field){
		
		int damage_done_this_fight = 0 ;
		
		if(canBeKilledInstantly(p)){
			this.HP = 0 ;
			return 0;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg =Math.round( EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								    Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG)));
										   
		
			p.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(PYROMANCER_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight =(field_increased_dmg +
					               (level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			p.decreaseHP(Math.round( EXECUTE_BASE_DMG +
					Percent.getPercent(PYROMANCER_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight = EXECUTE_BASE_DMG +
					                 (level * EXECUTE_LVL_INCREASE);
		
		}
		return damage_done_this_fight;
		
	}
	
	
	
	/**
	 * This method applies Excecute damage on the targeted Knight
	 * 
	 * @param k The Knight on which Execute spell is cast
	 * @param field The field where the Execute spell is cast
	 * @return Damage done by the Knight to the targeted Knight
	 */
	public int execute(Knight k ,int field){
		
		int damage_done_this_fight = 0 ;
		
		if(canBeKilledInstantly(k)){
			this.HP = 0 ;
			return 0;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg =Math.round( EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								    Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG)));
										   
		
			k.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight =(field_increased_dmg +
					               (level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			k.decreaseHP(Math.round( EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight = EXECUTE_BASE_DMG +
					                 (level * EXECUTE_LVL_INCREASE);
		
		}
		
		return damage_done_this_fight;
	}

	
	
	/**
	 * This method applies Execute damage on the targeted Wizard
	 * 
	 * @param w The wizard on which the Execute spell is cast
	 * @param field The field where the Execute spell is cast
	 * @return Damage done by the Knight to the targeted Wizard
	 */
	public int execute(Wizard w ,int field){
		
		int damage_done_this_fight = 0 ;
		
		if(canBeKilledInstantly(w)){
			this.HP = 0 ;
			return 0;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg =Math.round( EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								    Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG)));
										   
		
			w.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(WIZARD_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight =(field_increased_dmg +
					               (level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			w.decreaseHP(Math.round( EXECUTE_BASE_DMG +
					Percent.getPercent(WIZARD_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight = EXECUTE_BASE_DMG +
					                 (level * EXECUTE_LVL_INCREASE);
		
		}
		return damage_done_this_fight;

	}
	
	
    /**
     * This method applies Execute damage on the targeted Rogue
     * 
     * @param r The Rogue on which the Execute spell is cast
     * @param field The field where the execute spell is cast
     * @return Damage done by the Knight to the targeted Rogue
     */
	public int execute(Rogue r ,int field){
		
		int damage_done_this_fight = 0 ;
		
		if(canBeKilledInstantly(r)){
			this.HP = 0 ;
			return 0;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg =Math.round( EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								    Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG)));
										   
		
			r.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(ROGUE_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight =(field_increased_dmg +
					               (level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			r.decreaseHP(Math.round( EXECUTE_BASE_DMG +
					Percent.getPercent(ROGUE_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE)));
			
			damage_done_this_fight = EXECUTE_BASE_DMG +
					                 (level * EXECUTE_LVL_INCREASE);
		
		}
		return damage_done_this_fight;

	}

	
	/**
	 * This method applies Slam damage on the targeted Pyromancer
	 * 
	 * @param p The Pyromancer on which the Slam spell is cast
	 * @param field The field where the Slam spell is cast
	 * @return Damage done by the Knight to the targeted Pyromancer
	 */
	public int slam(Pyromancer p ,int field){
		
		int damage_done_this_fight = 0 ;
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG));
			
			p.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(PYROMANCER_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE)));
		
			damage_done_this_fight =(field_increased_dmg +
					               (level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			p.decreaseHP(Math.round( SLAM_BASE_DMG +
					Percent.getPercent(PYROMANCER_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE)));
			
			damage_done_this_fight=(SLAM_BASE_DMG +
					(level * SLAM_LVL_INCREASE));
			
		}
		
		return damage_done_this_fight;
	}
	
	
	/**
	 * 
	 * This method applies Slam damage on the targeted Knight
	 * 
	 * @param k The Knight on which the Slam spell is cast 
	 * @param field The field on which the Spell spell is cast
	 * @return Damage done by the Knight to the targeted Knight
	 */
	public int slam(Knight k ,int field){
		
		int damage_done_this_fight = 0 ;
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG));
			
			k.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE)));
		
			
			damage_done_this_fight =(field_increased_dmg +
					               (level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			k.decreaseHP(Math.round( SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE)));
			
			damage_done_this_fight=(SLAM_BASE_DMG +
					(level * SLAM_LVL_INCREASE));
			
		}
		
		return damage_done_this_fight;
	}
	
	
	/**
	 * 
	 * This method applies Slam damage on the targeted Wizard
	 * 
	 * @param w The Wizard on which the Slam spell is cast
	 * @param field The field on which the Slam spell is cast
	 * @return Damage done by the Knight to the targeted Wizard
	 */
	public int slam(Wizard w ,int field){
		
		int damage_done_this_fight = 0 ;
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG));
			
			w.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(WIZARD_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE)));

			damage_done_this_fight =(field_increased_dmg +
					               (level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			w.decreaseHP(Math.round( SLAM_BASE_DMG +
					Percent.getPercent(WIZARD_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE)));
			
			damage_done_this_fight=(SLAM_BASE_DMG +
					(level * SLAM_LVL_INCREASE));
			
		}
		
		return damage_done_this_fight;
	}

	
	/**
	 * 
	 * This method applies Slam damage on the targeted Rogue
	 *  
	 * @param r The Rogue on which the Slam spell is cast
	 * @param field The field on which the Slam spell is cast
	 * @return Damage done by the Knight to the targeted Rogue
	 */
	public int slam(Rogue r ,int field){
		
		int damage_done_this_fight = 0 ;
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG));
			
			r.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(ROGUE_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE)));
		 
			damage_done_this_fight =(field_increased_dmg +
					               (level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			r.decreaseHP(Math.round( SLAM_BASE_DMG +
					Percent.getPercent(ROGUE_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE)));
			
			damage_done_this_fight=(SLAM_BASE_DMG +
					(level * SLAM_LVL_INCREASE));
			
		}
		
		return damage_done_this_fight;
	}
	
	
	/**
	 * This method checks weather the field on which the battle is 
	 * being carried increases the Knight's damage
	 * 
	 * @param field The field value to be checked
	 * @return Returns true if the Knight can take advantage of the field
	 */
	private boolean checkField(int field){
		return field == Field.LAND;
	}
	
	/**
	 * This method check to see if the Knight can kill
	 * instantly the targeted Hero only by applying execute
	 * 
	 * @param h The Hero that can be killed instantly
	 * @return Returns true if the hero can be killed instantly
	 */
	public boolean canBeKilledInstantly(Hero h){
		
		int coefficient = h.level * 1;
		
		if(coefficient > 20)
			coefficient = 20 ;
		
		if(this.HP < Percent.getPercent(coefficient, this.maxHP))
			return true ;
		
		return false ;
	}
	
	
}
