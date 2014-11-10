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
	
	public static final int FIELD_DMG_INCREASE = 15;
	
	private boolean has_field_advantage ;
	
	public Pyromancer(){
		this.XP = 0;
		this.maxHP = 500;
		this.HP = 500;
		
	}
	
	
	public void fightsWith(Knight k , int field){
		
		this.fireblast(k, field);
		this.ignite(k, field);
		
		k.execute(this, field);
		k.slam(this, field);
	}
	
	
	public void fightsWith(Pyromancer p , int field){
		
		this.fireblast(p, field);
		this.ignite(p, field);
		
		p.fireblast(this, field);
		p.ignite(this, field);
		
	}
	
	public void fightsWith(Wizard k , int field){
		
	}
	
	public void fightsWith(Rogue k , int field){
		
	}

	
	
	public void fireblast(Pyromancer p ,int field){
		
		if(has_field_advantage){
			
			int field_increased_dmg = FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_BASE_DMG));
										   
		
			p.decreaseHP(field_increased_dmg +
					Percent.getPercent(PYROMANCER_FIREBLAST_DMG_INCREASE, field_increased_dmg)+
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			p.decreaseHP(FIREBLAST_BASE_DMG +
					Percent.getPercent(PYROMANCER_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG) +
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
		
	}
	
	public void fireblast(Knight k ,int field){
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_BASE_DMG));
										   
		
			k.decreaseHP(field_increased_dmg +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, field_increased_dmg)+
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			k.decreaseHP(FIREBLAST_BASE_DMG +
					Percent.getPercent(KNIGHT_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG) +
					(level * FIREBLAST_LVL_INCREASE));
		
		}

		
	}
	
	public void fireblast(Wizard w , int field){
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_BASE_DMG));
										   
		
			w.decreaseHP(field_increased_dmg +
					Percent.getPercent(WIZARD_FIREBLAST_DMG_INCREASE, field_increased_dmg)+
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			w.decreaseHP(FIREBLAST_BASE_DMG +
					Percent.getPercent(WIZARD_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG) +
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
	}
	
	public void fireblast(Rogue r ,int field){
		
		
		if(has_field_advantage){
			
			int field_increased_dmg = FIREBLAST_BASE_DMG +
								   (level * FIREBLAST_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,FIREBLAST_BASE_DMG + (level * FIREBLAST_BASE_DMG));
										   
		
			r.decreaseHP(field_increased_dmg +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, field_increased_dmg)+
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			r.decreaseHP(FIREBLAST_BASE_DMG +
					Percent.getPercent(ROGUE_FIREBLAST_DMG_INCREASE, FIREBLAST_BASE_DMG) +
					(level * FIREBLAST_LVL_INCREASE));
		
		}
		
		
	}
	
	public void ignite(Pyromancer p ,int field){
		
	}

	public void ignite(Knight k ,int field){
		
	}
	
	public void ignite(Wizard w ,int field){
		
	}
	
	public void ignite(Rogue r ,int field){
		
	}
	
	
	private boolean checkField(int field){
		return field == Field.VOLCANIC;
	}
}

