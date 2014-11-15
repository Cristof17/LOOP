package main;

/**
 * 
 * @author cristof
 *
 */
public class Rogue extends Hero {

	public static final int HP_INCREMENT = 40;
	
	public static final int PYROMANCER_BACKSTAB_DMG_INCREASE = 25;
	public static final int KNIGHT_BACKSTAB_DMG_INCREASE = -10;
	public static final int WIZARD_BACKSTAB_DMG_INCREASE = 25;
	public static final int ROGUE_BACKSTAB_DMG_INCREASE = 20;
	
	public static final int PYROMANCER_PARALYSIS_DMG_INCREASE = 20;
	public static final int KNIGHT_PARALYSIS_DMG_INCREASE = -20;
	public static final int WIZARD_PARALYSIS_DMG_INCREASE = 25;
	public static final int ROGUE_PARALYSIS_DMG_INCREASE = -10;
	
	public static final int BACKSTAB_BASE_DAMAGE = 200 ;
	public static final int BACKSTAB_LVL_INCREASE = 40 ;
	
	public static final int PARALYSIS_BASE_DAMAGE = 40;
	public static final int PARALYSIS_LVL_INCREASE = 10 ;
	
	public static final int FIELD_INCREASED_DMG = 15 ;
	
	private int hit_counter = 0 ;
	
	public int backstab_hits = 0 ;
	
	public Rogue(){
		this.XP = 0;
		this.HP = 600;
		this.maxHP = 600;
		this.backstab_hits = 0; 
	}
	
	public void damages(Hero h , int field , int round ){
		h.isDamagedBy(this, field, round);
	}
	
	
	/**
	 * @param p The Pyromancer with which the Rogue fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Pyromancer p , int field , int round ){
		
		this.backstab(p, field);
		this.paralysis(p, field);
		
		p.fireblast(this, field);
		p.ignite(this, field);
	}
	
	
	/**
	 * @param w The Wizard with which the Rogue fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Wizard w ,int field ,int round ){
		
		float dmg_backstab = this.backstab(w, field);
		float dmg_paralysis = this.paralysis(w, field);
		
		w.drain(this,field);
		w.deflect(this, field, dmg_backstab, dmg_paralysis);
		
	}
	
	
	/**
	 * @param k The Knight with which the Rogue fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Knight k , int field ,int round ){
		
		this.backstab(k, field);
		this.paralysis(k, field);
		
		k.execute(this, field);
		k.slam(this, field);
	}
	
	
	/**
	 * @param r The Rogue with which the Rogue fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Rogue r ,int field ,int round){
		
		this.backstab(r, field);
		this.paralysis(r, field);
		
		r.backstab(this, field);
		r.paralysis(this, field);
		
	}

	
	/**
	 * This method applies Backstab damage on the targeted Pyromancer
	 * 
	 * @param p The targeted Pyromancer
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Rogue to the Pyromancer
	 */
	public float backstab(Pyromancer p , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = this.checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE));
			
			damage_done_this_fight = field_increased_damage ;
			
			if(hit_counter % 3 == 0 ){
				field_increased_damage  = Percent.getPercent(150 , field_increased_damage);
				this.hit_counter = 0 ;
			}
			
			p.decreaseHP(Math.round(Percent.getPercent(100 + PYROMANCER_BACKSTAB_DMG_INCREASE,field_increased_damage)));
			
		}else{
			
			float damage = BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE);
			
			p.decreaseHP(Math.round(Percent.getPercent(100 + PYROMANCER_BACKSTAB_DMG_INCREASE, damage)));
			
			damage_done_this_fight = damage ; 
		}
		
		this.hit_counter ++ ;
		
		return damage_done_this_fight ;
		
		
	}
	
	
	/**
	 * This method applies Backstab damage on the targeted Knight
	 * 
	 * @param k The targeted Knight
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Rogue to the Knight 
	 */
	public float backstab(Knight k , int field){
	
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = this.checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE));
			
			damage_done_this_fight = field_increased_damage ;
			
			if(hit_counter % 3 == 0 ){
				field_increased_damage  = Percent.getPercent(150 , field_increased_damage);
				this.hit_counter = 0 ;
			}
			
			k.decreaseHP(Math.round(Percent.getPercent(100 + KNIGHT_BACKSTAB_DMG_INCREASE,field_increased_damage)));
			
		}else{
			
			float damage = BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE);
			
			k.decreaseHP(Math.round(Percent.getPercent(100 + KNIGHT_BACKSTAB_DMG_INCREASE, damage)));
			
			damage_done_this_fight = damage ; 
		}
		
		this.hit_counter ++ ;
		
		return damage_done_this_fight ;
		
	}
	
	
	/**
	 * This method applies Backstab damage on the targeted Wizard
	 * 
	 * @param w The targeted Wizard
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Rogue to the Wizard
	 */
	public float backstab(Wizard w , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = this.checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE));
			
			damage_done_this_fight = field_increased_damage ;
			
			if(hit_counter % 3 == 0 ){
				field_increased_damage  = Percent.getPercent(150 , field_increased_damage);
				this.hit_counter = 0 ;
			}
			
			w.decreaseHP(Math.round(Percent.getPercent(100 + WIZARD_BACKSTAB_DMG_INCREASE,field_increased_damage)));
			
		}else{
			
			float damage = BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE);
			
			w.decreaseHP(Math.round(Percent.getPercent(100 + WIZARD_BACKSTAB_DMG_INCREASE, damage)));
			
			damage_done_this_fight = damage ; 
		}
		
		this.hit_counter ++ ;
		
		return damage_done_this_fight ;
		
	}
	
	
	/**
	 * This method applies Backstab damage on the targeted Rogue
	 * 
	 * @param r The targeted Rogue
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Rogue to the other Rogue
	 */
	public float backstab(Rogue r , int field ){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = this.checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE));
			
			damage_done_this_fight = field_increased_damage ;
			
			if(hit_counter % 3 == 0 ){
				field_increased_damage  = Percent.getPercent(150 , field_increased_damage);
				this.hit_counter = 0 ;
			}
			
			r.decreaseHP(Math.round(Percent.getPercent(100 + ROGUE_BACKSTAB_DMG_INCREASE,field_increased_damage)));
			
		}else{
			
			float damage = BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE);
			
			r.decreaseHP(Math.round(Percent.getPercent(100 + ROGUE_BACKSTAB_DMG_INCREASE, damage)));
			
			damage_done_this_fight = damage ; 
		}
		
		this.hit_counter ++ ;
		
		return damage_done_this_fight ;
		
	}
	
	
	
	
	/**
	 * This method applies Paralysis damage on the targeted Pyromancer
	 * 
	 * @param p The targeted Pyromancer
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Rogue to the Pyromancer
	 */
	public float paralysis(Pyromancer p , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_LVL_INCREASE));
			
			p.decreaseHP(Math.round(Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE, field_increased_damage )));
			
			p.setDamageOverTime(Math.round(Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE, field_increased_damage)), 6 , true);
			
			damage_done_this_fight = field_increased_damage;
			
		}else{
			
			float damage = PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_BASE_DAMAGE);
			
			p.decreaseHP(Math.round( Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE, damage)));
			
			p.setDamageOverTime(Math.round(Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE , damage)), 3, true);
			
			damage_done_this_fight = damage; 
			
		}
		
		return damage_done_this_fight;
		
	}
	
	/**
	 * This method applies Paralysis damage on the targeted Knight
	 * 
	 * @param k The targeted Knight
	 * @param field The field where the spell is being casted
	 * @return Damage done by the Rogue to the Knight
	 */
	public float paralysis(Knight k , int field){

		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_LVL_INCREASE));
			
			k.decreaseHP(Math.round(Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE, field_increased_damage )));
			
			k.setDamageOverTime(Math.round(Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE, field_increased_damage)), 6 , true);
			
			damage_done_this_fight = field_increased_damage;
			
		}else{
			
			float damage = PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_BASE_DAMAGE);
			
			k.decreaseHP(Math.round( Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE, damage)));
			
			k.setDamageOverTime(Math.round(Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE , damage)), 3, true);
			
			damage_done_this_fight = damage; 
			
		}
		
		return damage_done_this_fight;

		
	}

	
	/**
	 * This method applies Paralysis damage on the targeted Wizard
	 *  
	 * @param w The targeted Wizard
	 * @param field The field where the spell is being casted
	 * @return Damage done by the Rogue to the targeted Wizard
	 */
	public float paralysis(Wizard w , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_LVL_INCREASE));
			
			w.decreaseHP(Math.round(Percent.getPercent(100 + WIZARD_PARALYSIS_DMG_INCREASE, field_increased_damage )));
			
			w.setDamageOverTime(Math.round(Percent.getPercent(100 + WIZARD_PARALYSIS_DMG_INCREASE, field_increased_damage)), 6 , true);
			
			damage_done_this_fight = field_increased_damage;
			
		}else{
			
			float damage = PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_BASE_DAMAGE);
			
			w.decreaseHP(Math.round( Percent.getPercent(100 + WIZARD_PARALYSIS_DMG_INCREASE, damage)));
			
			w.setDamageOverTime(Math.round(Percent.getPercent(100 + WIZARD_PARALYSIS_DMG_INCREASE , damage)), 3, true);
			
			damage_done_this_fight = damage; 
			
		}
		
		return damage_done_this_fight;

		
	}

	
	/**
	 * This method applies Paralysis damage on the targeted Rogue
	 * 
	 * @param r The targeted Rogue
	 * @param field The field where the spell is being casted
	 * @return Damage done by the Rogue to the other Rogue
	 */
	public float paralysis(Rogue r , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Percent.getPercent(100 + FIELD_INCREASED_DMG, PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_LVL_INCREASE));
			
			r.decreaseHP(Math.round(Percent.getPercent(100 + ROGUE_PARALYSIS_DMG_INCREASE, field_increased_damage )));
			
			r.setDamageOverTime(Math.round(Percent.getPercent(100 + ROGUE_PARALYSIS_DMG_INCREASE, field_increased_damage)), 6 , true);
			
			damage_done_this_fight = field_increased_damage;
			
		}else{
			
			float damage = PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_BASE_DAMAGE);
			
			r.decreaseHP(Math.round( Percent.getPercent(100 + ROGUE_PARALYSIS_DMG_INCREASE, damage)));
			
			r.setDamageOverTime(Math.round(Percent.getPercent(100 + ROGUE_PARALYSIS_DMG_INCREASE , damage)), 3, true);
			
			damage_done_this_fight = damage; 
			
		}
		
		return damage_done_this_fight;
		
	}
	
	
	/**
	 * This method checks weather the field on which the battle is 
	 * being carried increases the Rogue's damage
	 * 
	 * @param field The field value to be tested
	 * @return Returns true if the Rogue is on it's specific field
	 */
	private boolean checkField(int field){
		return field == Field.WOODS;
	}

}
