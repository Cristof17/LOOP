package eroi;

import Calculus.Percent;
import field.Field;

public class Pyromancer extends Hero {

	public static final int HP_INCREMENT = 50;
	
	public static final int PYROMANCER_FIREBLAST_DMG_INCREASE = -10;
	public static final int KNIGHT_FIREBLAST_DMG_INCREASE = 20;
	public static final int WIZARD_FIREBLAST_DMG_INCREASE = 5;
	public static final int ROGUE_FIREBLAST_DMG_INCREASE = -20;
	
	public static final int PYROMANCER_IGNITE_DMG_INCREASE = -10;
	public static final int KNIGHT_IGNITE_DMG_INCREASE = 20;
	public static final int WIZARD_IGNITE_DMG_INCREASE = 5;
	public static final int ROGUE_IGNITE_DMG_INCREASE = -20;
	
	public static final int FIREBLAST_BASE_DMG = 350 ;
	public static final int FIREBLAST_LVL_INCREASE = 50 ;
	
	public static final int IGNITE_BASE_DMG = 150;
	public static final int IGNITE_LVL_INCREASE = 20 ;
	public static final int IGNITE_ROUND_DAMAGE = 50 ;
	public static final int IGNITE_ROUND_DAMAGE_LVL_INCREASE = 30;
	
	public static final int FIELD_DMG_INCREASE = 25;
	
	private boolean has_field_advantage ;
	
	public Pyromancer(){
		this.XP = 0;
		this.maxHP = 500;
		this.HP = 500;
		
	}
	
	
	public void damages(Hero h , int field , int round ){
		h.isDamagedBy(this, field, round);
	}
	
	
	public void isDamagedBy(Pyromancer p , int field , int round ){
		
		this.fireblast(p, field);
		this.ignite(p, field);
		
		p.fireblast(this, field);
		p.ignite(this, field);
		
	}
	
	public void isDamagedBy(Wizard w ,int field ,int round ){
		
		float dmg_fireblast = this.fireblast(w, field);
		float dmg_ignite = this.ignite(w, field);
		
		w.drain(this, field);
		w.deflect(this, field, dmg_fireblast, dmg_ignite);
		
	}
	
	public void isDamagedBy(Knight k , int field ,int round ){
		
		this.fireblast(k, field);
		this.ignite(k, field);
		
		k.execute(this, field);
		k.slam(this, field);
		
	}
	
	public void isDamagedBy(Rogue r ,int field ,int round){
		
	}

	public float fireblast(Pyromancer p ,int field){
		
		int damage_done_this_fight = 0;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)));
										   
		
			p.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(PYROMANCER_FIREBLAST_DMG_INCREASE, field_increased_dmg)));
			
			damage_done_this_fight = field_increased_dmg ;
		
		}
		
		else if(!has_field_advantage){
		
			p.decreaseHP(Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(PYROMANCER_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE))));
		
			damage_done_this_fight =  Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(PYROMANCER_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE)));
			
			damage_done_this_fight = Math.round(FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)); 
		}
		
		return damage_done_this_fight ;
	
		
	}
	
	public float fireblast(Knight k ,int field){
		int damage_done_this_fight = 0;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)));
										   
		
			k.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, field_increased_dmg)));
			
			damage_done_this_fight = field_increased_dmg ;
		
		}
		
		else if(!has_field_advantage){
		
			k.decreaseHP(Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE))));
		
			damage_done_this_fight =  Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE)));
			
			damage_done_this_fight = Math.round(FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)); 
		}
		
		return damage_done_this_fight ;
			
	}
	
	public float fireblast(Wizard w , int field){
		
		
		int damage_done_this_fight = 0;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)));
										   
		
			w.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(WIZARD_FIREBLAST_DMG_INCREASE, field_increased_dmg)));
			
			damage_done_this_fight = field_increased_dmg ;
		
		}
		
		else if(!has_field_advantage){
		
			w.decreaseHP(Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(WIZARD_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE))));
		
			damage_done_this_fight =  Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(WIZARD_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE)));
			
			damage_done_this_fight = Math.round(FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)); 
		}
		
		return damage_done_this_fight ;
		
		
	}
	
	public float fireblast(Rogue r ,int field){
		
		
		int damage_done_this_fight = 0;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)));
										   
		
			r.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, field_increased_dmg)));
			
			damage_done_this_fight = field_increased_dmg ;
		
		}
		
		else if(!has_field_advantage){
		
			r.decreaseHP(Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE))));
		
			damage_done_this_fight =  Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE)));
			
			damage_done_this_fight = Math.round(FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)); 
		}
		
		return damage_done_this_fight ;
	
	}
	
	public float ignite(Pyromancer p ,int field){
		
		has_field_advantage = checkField(field);
		
		float damage_done_this_fight  = 0 ;
		
		if(has_field_advantage){
			
			int field_increased_dmg_base = Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Math.round( Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE))));
									
		
			p.decreaseHP(Math.round( field_increased_dmg_base +
					Percent.getPercent(PYROMANCER_IGNITE_DMG_INCREASE, field_increased_dmg_base)));
			
			int field_increased_dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE)+
											Math.round(Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_LVL_INCREASE))));
			
			p.setDamageOverTime(Math.round(field_increased_dmg_round + Percent.getPercent(PYROMANCER_IGNITE_DMG_INCREASE, field_increased_dmg_round)),2,false);
		
			damage_done_this_fight = field_increased_dmg_base;
		}
		
		else if(!has_field_advantage){
			
		
			int dmg_base = Math.round( IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)); 
			
			p.decreaseHP(Math.round(dmg_base + Percent.getPercent(PYROMANCER_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG )));
			
			int dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE) +
							Math.round(Percent.getPercent(PYROMANCER_IGNITE_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE))));
		
			p.setDamageOverTime(dmg_round, 2, false);
			damage_done_this_fight =  dmg_base ;
		
		}		
		
		
		return damage_done_this_fight ;
		
	}

	public float ignite(Knight k ,int field){
		
		has_field_advantage = checkField(field);
		
		float damage_done_this_fight  = 0 ;
		
		if(has_field_advantage){
			
			int field_increased_dmg_base = Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Math.round( Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE))));
									
		
			k.decreaseHP(Math.round( field_increased_dmg_base +
					Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, field_increased_dmg_base)));
			
			
			int field_increased_dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE)+
					Math.round(Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_LVL_INCREASE))));

			k.setDamageOverTime(Math.round(field_increased_dmg_round + Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, field_increased_dmg_round)),2,false);
		
			damage_done_this_fight = field_increased_dmg_base;
		}
		
		else if(!has_field_advantage){
			
		
			int dmg_base = Math.round( IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)); 
			
			k.decreaseHP(Math.round(dmg_base + Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG )));
			
			int dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE) +
					Math.round(Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE))));

			k.setDamageOverTime(dmg_round, 2, false);

			
			damage_done_this_fight =  dmg_base ;
		
		}		
		
		
		return damage_done_this_fight ;
		
	}
	
	public float ignite(Wizard w ,int field){
	

		has_field_advantage = checkField(field);
		
		float damage_done_this_fight  = 0 ;
		
		if(has_field_advantage){
			
			int field_increased_dmg_base = Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Math.round( Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE))));
									
		
			w.decreaseHP(Math.round( field_increased_dmg_base +
					Percent.getPercent(WIZARD_IGNITE_DMG_INCREASE, field_increased_dmg_base)));
			
			
			int field_increased_dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE)+
					Math.round(Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_LVL_INCREASE))));

			w.setDamageOverTime(Math.round(field_increased_dmg_round + Percent.getPercent(WIZARD_IGNITE_DMG_INCREASE, field_increased_dmg_round)),2,false);
			
			damage_done_this_fight = field_increased_dmg_base;
		}
		
		else if(!has_field_advantage){
			
		
			int dmg_base = Math.round( IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)); 
			
			w.decreaseHP(Math.round(dmg_base + Percent.getPercent(WIZARD_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG )));
			
			int dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE) +
					Math.round(Percent.getPercent(WIZARD_IGNITE_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE))));

			w.setDamageOverTime(dmg_round, 2, false);

			
			damage_done_this_fight =  dmg_base ;
		
		}		
		
		
		return damage_done_this_fight ;
		
	}
	
	public float ignite(Rogue r ,int field){
		
		
		has_field_advantage = checkField(field);
		
		float damage_done_this_fight  = 0 ;
		
		if(has_field_advantage){
			
			int field_increased_dmg_base = Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Math.round( Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE))));
									
		
			r.decreaseHP(Math.round( field_increased_dmg_base +
					Percent.getPercent(ROGUE_IGNITE_DMG_INCREASE, field_increased_dmg_base)));
			
			
			int field_increased_dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE)+
					Math.round(Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_LVL_INCREASE))));

			r.setDamageOverTime(Math.round(field_increased_dmg_round + Percent.getPercent(ROGUE_IGNITE_DMG_INCREASE, field_increased_dmg_round)),2,false);
		
			damage_done_this_fight = field_increased_dmg_base;
		}
		
		else if(!has_field_advantage){
			
		
			int dmg_base = Math.round( IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)); 
			
			r.decreaseHP(Math.round(dmg_base + Percent.getPercent(ROGUE_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG )));
			
			int dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE) +
					Math.round(Percent.getPercent(ROGUE_IGNITE_DMG_INCREASE, IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE))));

			r.setDamageOverTime(dmg_round, 2, false);

			damage_done_this_fight =  dmg_base ;
		
		}		
		
		
		return damage_done_this_fight ;
		
	}
	
	
	private boolean checkField(int field){
		return field == Field.VOLCANIC;
	}
}

