package main;

/**
 * 
 * @author cristof
 *
 */
public class Wizard extends Hero {

	public static final int HP_INCREMENT = 30;
	
	public static final int PYROMANCER_DRAIN_DMG_INCREASE = -10;
	public static final int KNIGHT_DRAIN_DMG_INCREASE = 20;
	public static final int WIZARD_DRAIN_DMG_INCREASE = 5;
	public static final int ROGUE_DRAIN_DMG_INCREASE = -20;
	
	public static final int PYROMANCER_DEFLECT_DMG_INCREASE = 30;
	public static final int KNIGHT_DEFLECT_DMG_INCREASE = 40;
	public static final int WIZARD_DEFLECT_DMG_INCREASE = Integer.MAX_VALUE;
	public static final int ROGUE_DEFLECT_DMG_INCREASE = 20;
	
	public static final int FIELD_DAMAGE_INCREASE = 10 ;
	
	public static final int PROCENT_INCREASE = 5;
	
	public static final int DEFLECT_DMG_PROCENT = 35;
	public static final int DEFLECT_DMG_PROCENT_INCREASE = 2;
	public static final int DEFLECT_DMG_PROCENT_MAXIMUM = 70 ;
	
	private boolean has_field_advantage = false ;
	
	private float procent ;
	
	public Wizard(){
		this.XP = 0;
		this.HP = 400;
		this.maxHP = 400;
		this.procent = 20;
		
	}
	
	public void damages(Hero h , int field , int round ){
		h.isDamagedBy(this, field, round);
	}
	
	
	public void isDamagedBy(Pyromancer p , int field , int round ){
		
		float dmg_fireblast = p.fireblast(this, field);
		float dmg_ignite = p.ignite(this, field);
		
		this.drain(p, field); 
		this.deflect(p, field, dmg_fireblast , dmg_ignite);
		
	}
	
	/**
	 * @param w The Wizard with which the Wizard fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Wizard w ,int field ,int round ){
		
		this.drain(w, field);
		w.drain(this, field);
		
	}
	
	/**
	 * @param k The Knight with which the Wizard fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Knight k , int field ,int round ){
		
		int damage_taken_by_execute = k.execute(this, field);
		int damage_taken_by_slam = k.slam(this, field);
		
		this.drain(k,field);
		this.deflect(k, field,damage_taken_by_execute,
							  damage_taken_by_slam);
		
		
	}
	
	/**
	 * @param r The Rogue with which the Wizard fights 
	 * @param field The field where the fight is being taken 
	 */
	public void isDamagedBy(Rogue r ,int field ,int round){
		
		float damage_taken_by_backstab = r.backstab(this, field);
		float damage_taken_by_paralysis = r.paralysis(this, field);
		
		this.drain(r, field);
		this.deflect(r, field, damage_taken_by_backstab, damage_taken_by_paralysis);
		
	}

	/**
	 * This method applies Drain damage on the targeted Pyromancer
	 * 
	 * @param p
	 * @param field
	 * @return Damage done by the Wizard to the targeted Pyromancer
	 */
	public float drain(Pyromancer p , int field){
	
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + PYROMANCER_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * p.maxHP, p.HP))));
			
			
			p.decreaseHP(damage);
			
			int procent_without_race = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * p.maxHP, p.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_race * Math.min(0.3 * p.maxHP, p.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + PYROMANCER_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * p.maxHP, p.HP)));
			
			
			p.decreaseHP(damage); 
			
			int procent_without_race = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * p.maxHP, p.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
		
	}
	
	
	/**
	 * This method applies Drain damage on the targeted Knight
	 * 
	 * @param k The targeted Knight
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Wizard on the targeted Knight
	 */
	public float drain(Knight k , int field){
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + KNIGHT_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * k.maxHP, k.HP))));
			
			
			k.decreaseHP(damage);
			
			int procent_without_race = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * k.maxHP, k.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_race * Math.min(0.3 * k.maxHP, k.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + KNIGHT_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * k.maxHP, k.HP)));
			
			
			k.decreaseHP(damage); 
			
			int procent_without_race = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * k.maxHP, k.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
	}	
	
	
	/**
	 * This method applies Drain damage on the targeted Wizard
	 * 
	 * @param w The targeted Wizard
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Wizard to the targeted Wizard
	 */
	public float drain(Wizard w , int field){
	
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + WIZARD_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * w.maxHP, w.HP))));
			
			
			w.decreaseHP(damage);
			
			int procent_without_race = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * w.maxHP, w.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_race * Math.min(0.3 * w.maxHP, w.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + WIZARD_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * w.maxHP, w.HP)));
			
			
			w.decreaseHP(damage); 
			
			int procent_without_race = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * w.maxHP, w.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
		
	}
	
	
	/**
	 * This method applies Drain damage on the targeted Rogue
	 * 
	 * @param r The targeted Rogue
	 * @param field The field where the spell is being cast
	 * @return Damage done by the Wizard to the targeted Rogue
	 */
	public float drain(Rogue r , int field){
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + ROGUE_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * r.maxHP, r.HP))));
			
			
			r.decreaseHP(damage);
			
			int procent_without_race = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * r.maxHP, r.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_race * Math.min(0.3 * r.maxHP, r.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + ROGUE_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * r.maxHP, r.HP)));
			
			
			r.decreaseHP(damage); 
			
			int procent_without_race = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_race ,(int) Math.min(0.3 * r.maxHP, r.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
		
	}
	
	/**
	 * This method applies Deflect damage on the targeted Pyromancer
	 * 
	 * @param p The targeted Pyromancer
	 * @param field The field where the spell is being cast
	 * @param damage1 Damage done by the Fireblast spell of the Pyromancer 
	 * @param damage2 Damage done by the Ignite spell of the Pyromancer
	 * @return Damage done by the Wizard to the targeted Pyromancer
	 */
	public float deflect(Pyromancer p ,int field ,float damage1 , float damage2){
		
		int damage_done_this_fight = 0;
		int damage_percent = 0 ;
		
		if(35 + (level * 2) > 70){
			damage_percent = 70;
		}else{
			damage_percent = 35 + (level * 2);
		}
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			

			
			float damage_with_race_damage1 = Percent.getPercent(35 + (level * 2),damage1 + Percent.getPercent(PYROMANCER_DEFLECT_DMG_INCREASE , damage1)); 
			
			float damage_with_race_damage2 = Percent.getPercent(35 +(level * 2), damage2 + Percent.getPercent(PYROMANCER_DEFLECT_DMG_INCREASE , damage2));
			
			float damage_total = damage_with_race_damage1 + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_with_race_damage1) + Percent.getPercent(FIELD_DAMAGE_INCREASE,  damage_with_race_damage2)+damage_with_race_damage2; 
			
			p.decreaseHP(Math.round(damage_total));
			
			damage_done_this_fight = 1;
			
		}
		else if(!has_field_advantage){
			
			float damage_without_race_damage1 =Math.round( Percent.getPercent(damage_percent, damage1));
		
			float damage_without_race_damage2 =Math.round( Percent.getPercent(damage_percent, damage2));
			
			float damage_with_race_damage1  = Percent.getPercent (35 + (level *2 ),damage1 + Percent.getPercent(PYROMANCER_DEFLECT_DMG_INCREASE, damage1));
			
			float damage_with_race_damage2  = Percent.getPercent (35 + (level * 2) ,damage2 + Percent.getPercent(PYROMANCER_DEFLECT_DMG_INCREASE, damage2));
			
			p.decreaseHP(Math.round(damage_with_race_damage1 + damage_with_race_damage2));
			
			
			damage_done_this_fight = (int) (damage_without_race_damage1 + damage_with_race_damage2);
		}
		
		return damage_done_this_fight;
		
	}

	/**
	 * This method applies Deflect damage on the targeted Knight
	 * 
	 * @param k The targeted Knight
	 * @param field The field where the spell is being cast
	 * @param damage1 Damage done by the Execute spell of the Knight
	 * @param damage2 Damage done by the Slam spell of the Knight
	 * @return Damage done by the Wizard to the targeted Knight
	 */
	public int deflect(Knight k , int field , float damage1 , float damage2){
		
		int damage_done_this_fight = 0;
		int damage_percent = 0 ;
		
		if(35 + (level * 2) > 70){
			damage_percent = 70;
		}else{
			damage_percent = 35 + (level * 2);
		}
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			

			
			float damage_with_race_damage1 = Percent.getPercent(35 + (level * 2),damage1 + Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE , damage1)); 
			
			float damage_with_race_damage2 = Percent.getPercent(35 +(level * 2), damage2 + Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE , damage2));
			
			float damage_total = damage_with_race_damage1 + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_with_race_damage1) + Percent.getPercent(FIELD_DAMAGE_INCREASE,  damage_with_race_damage2)+damage_with_race_damage2; 
			
			k.decreaseHP(Math.round(damage_total));
			
			damage_done_this_fight = 1;
			
		}
		else if(!has_field_advantage){
			
			float damage_without_race_damage1 =Math.round( Percent.getPercent(damage_percent, damage1));
		
			float damage_without_race_damage2 =Math.round( Percent.getPercent(damage_percent, damage2));
			
			float damage_with_race_damage1  = Percent.getPercent (35 + (level *2 ),damage1 + Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE, damage1));
			
			float damage_with_race_damage2  = Percent.getPercent (35 + (level * 2) ,damage2 + Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE, damage2));
			
			k.decreaseHP(Math.round(damage_with_race_damage1 + damage_with_race_damage2));
			
			
			damage_done_this_fight = (int) (damage_without_race_damage1 + damage_with_race_damage2);
		}
		
		return damage_done_this_fight;
	}
	
	/**
	 * This method applies Deflect damage on the targeted Rogue
	 * 
	 * @param r The targeted Rogue
	 * @param field The field where the spell is being cast
	 * @param damage1 Damage done by the Backstab spell of the Rogue
	 * @param damage2 Damage done by the Paralysis spell of the Rogue
	 * @return Damage done by the Wizard to the targeted Rogue
	 */
	public int deflect(Rogue r ,int field ,float damage1 , float damage2){
		
		int damage_done_this_fight = 0;
		int damage_percent = 0 ;
		
		if(35 + (level * 2) > 70){
			damage_percent = 70;
		}else{
			damage_percent = 35 + (level * 2);
		}
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			

			
			float damage_with_race_damage1 = Percent.getPercent(35 + (level * 2),damage1 + Percent.getPercent(ROGUE_DEFLECT_DMG_INCREASE , damage1)); 
			
			float damage_with_race_damage2 = Percent.getPercent(35 +(level * 2), damage2 + Percent.getPercent(ROGUE_DEFLECT_DMG_INCREASE , damage2));
			
			float damage_total = damage_with_race_damage1 + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_with_race_damage1) + Percent.getPercent(FIELD_DAMAGE_INCREASE,  damage_with_race_damage2)+damage_with_race_damage2; 
			
			r.decreaseHP(Math.round(damage_total));
			
			damage_done_this_fight = 1;
			
		}
		else if(!has_field_advantage){
			
			float damage_without_race_damage1 =Math.round( Percent.getPercent(damage_percent, damage1));
		
			float damage_without_race_damage2 =Math.round( Percent.getPercent(damage_percent, damage2));
			
			float damage_with_race_damage1  = Percent.getPercent (35 + (level *2 ),damage1 + Percent.getPercent(ROGUE_DEFLECT_DMG_INCREASE, damage1));
			
			float damage_with_race_damage2  = Percent.getPercent (35 + (level * 2) ,damage2 + Percent.getPercent(ROGUE_DEFLECT_DMG_INCREASE, damage2));
			
			r.decreaseHP(Math.round(damage_with_race_damage1 + damage_with_race_damage2));
			
			
			damage_done_this_fight = (int) (damage_without_race_damage1 + damage_with_race_damage2);
		}
		
		return damage_done_this_fight;
	}
	
	
	/**
	 * This method checks weather the field on which the battle is 
	 * being carried increases the Wizard's damage
	 * 
	 * @param field The field value to be tested
	 * @return Returns true if the Wizard is on it's specific field
	 */
	private boolean checkField(int field){
		return field == Field.DESERT;
	}
	
}
