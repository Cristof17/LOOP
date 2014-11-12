package eroi;

import Calculus.Percent;
import field.Field;

public class Pyromancer extends Hero{

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
	
	
	public void fightsWith(Knight k , int field , int round){
		
		this.fireblast(k, field);
		this.ignite(k, field);
		
		k.execute(this, field);
		k.slam(this, field);
		
	}
	
	
	public void fightsWith(Pyromancer p , int field , int round){
		
		this.fireblast(p, field);
		this.ignite(p, field);
		
		p.fireblast(this, field);
		p.ignite(this, field);
		
		
		
	}
	
	public void fightsWith(Wizard k , int field ,int round){
		
	}
	
	public void fightsWith(Rogue k , int field , int round){
		
	}

	
	
	public float fireblast(Pyromancer p ,int field){
		
		int damage_done_this_fight = 0;
		
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
	
	public void fireblast(Knight k ,int field){
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)));
										   
		
			k.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, field_increased_dmg)));
		
		}
		
		else if(!has_field_advantage){
			
		
			k.decreaseHP(Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE))));
		
		}

		
	}
	
	public float fireblast(Wizard w , int field){
		
		
		int damage_done_this_fight = 0;
		
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
	
	public void fireblast(Rogue r ,int field){
		
		
		if(has_field_advantage){
			
			int field_increased_dmg = Math.round( FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_LVL_INCREASE)));
										   
		
			r.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, field_increased_dmg)));
		
		}
		
		else if(!has_field_advantage){
			
		
			r.decreaseHP(Math.round( FIREBLAST_BASE_DMG +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG +
					(level * FIREBLAST_LVL_INCREASE))));
		
		}
		
		
	}
	
	public void ignite(Pyromancer p ,int field){
		
		if(has_field_advantage){
			
			int field_increased_dmg =Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)));
										   
		
			p.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(PYROMANCER_IGNITE_DMG_INCREASE, field_increased_dmg)));
		
		}
		
		else if(!has_field_advantage){
			
		
			p.decreaseHP(Math.round( IGNITE_BASE_DMG +
					Percent.getPercent(PYROMANCER_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG +
					(level * IGNITE_LVL_INCREASE))));
		
		}
		
		
	}

	public float ignite(Knight k ,int field){
		
		has_field_advantage = checkField(field);
		
		int damage_done_this_fight  = 0 ;
		
		if(has_field_advantage){
			
			int field_increased_dmg_base =Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Math.round( Percent.getPercent(FIELD_DMG_INCREASE,IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE))));
									
		
			k.decreaseHP(Math.round( field_increased_dmg_base +
					Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, field_increased_dmg_base)));
			
			
			k.setDamageOverTime(IGNITE_ROUND_DAMAGE +
								Math.round(Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_ROUND_DAMAGE +(level * IGNITE_ROUND_DAMAGE_LVL_INCREASE))), 2, false);
		
			damage_done_this_fight = field_increased_dmg_base;
		}
		
		else if(!has_field_advantage){
			
		
			int dmg_base = Math.round( IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)); 
			
			k.decreaseHP(Math.round(dmg_base + Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG )));
			
			int dmg_round = Math.round(IGNITE_ROUND_DAMAGE + (level * IGNITE_ROUND_DAMAGE_LVL_INCREASE)); 
			
			k.decreaseHP(Math.round( dmg_round + Percent.getPercent(KNIGHT_IGNITE_DMG_INCREASE, dmg_round)));
			
			damage_done_this_fight =  dmg_base + dmg_round ;
		
		}		
		
		
		return damage_done_this_fight ;
		
	}
	
	public float ignite(Wizard w ,int field){
	

		has_field_advantage = checkField(field);
		
		float damage_done_this_fight  = 0 ;
		
		if(has_field_advantage){
			
			int field_increased_dmg_base =Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Math.round( Percent.getPercent(FIELD_DMG_INCREASE,IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE))));
									
		
			w.decreaseHP(Math.round( field_increased_dmg_base +
					Percent.getPercent(WIZARD_IGNITE_DMG_INCREASE, field_increased_dmg_base)));
			
			
			w.setDamageOverTime(IGNITE_ROUND_DAMAGE +
								Math.round(Percent.getPercent(FIELD_DMG_INCREASE, IGNITE_ROUND_DAMAGE +(level * IGNITE_ROUND_DAMAGE_LVL_INCREASE))), 2, false);
		
			damage_done_this_fight = field_increased_dmg_base;
		}
		
		else if(!has_field_advantage){
			
		
			int dmg_base = Math.round( IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)); 
			
			w.decreaseHP(Math.round(dmg_base + Percent.getPercent(WIZARD_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG )));
			
			
			damage_done_this_fight =  dmg_base ;
		
		}		
		
		
		return damage_done_this_fight ;
		
	}
	
	public void ignite(Rogue r ,int field){
		
		
		if(has_field_advantage){
			
			int field_increased_dmg =Math.round( IGNITE_BASE_DMG +
								   (level * IGNITE_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,IGNITE_BASE_DMG + (level * IGNITE_LVL_INCREASE)));
										   
		
			r.decreaseHP(Math.round( field_increased_dmg +
					Percent.getPercent(ROGUE_IGNITE_DMG_INCREASE, field_increased_dmg)));
		
		}
		
		else if(!has_field_advantage){
			
		
			r.decreaseHP(Math.round( IGNITE_BASE_DMG +
					Percent.getPercent(ROGUE_IGNITE_DMG_INCREASE, IGNITE_BASE_DMG +
					(level * IGNITE_LVL_INCREASE))));
		
		}
		
	}
	
	
	private boolean checkField(int field){
		return field == Field.VOLCANIC;
	}
}

