package eroi;

import field.Field;
import Calculus.Percent;

public final class Knight extends Hero{
	
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
	
	private static final int ONE_PERCENT = 1 ;
	
	private boolean has_field_advantage = false;
	
	private int instant_kill_limit = 20;
	private static final int INSTANT_KILL_LIMIT_MAX = 40 ;
	
	
	public Knight(){
		this.XP = 0;
		this.HP = 900;
		this.maxHP = 900;
		this.instant_kill_limit = 20 ;
		
	}
	
	
	public void fightsWith(Knight k , int field){
		
		this.execute(k, field);
		k.execute(this, field);
		
		this.slam(k, field);
		k.slam(this, field);
	}
	
	
	public void fightsWith(Pyromancer p , int field){
		this.execute(p, field);
		
	}
	
	public void fightsWith(Wizard k , int field){
		
	}
	
	public void fightsWith(Rogue k , int field){
		
	}
	
	
	
	
	public void execute(Pyromancer p, int field){
		
		
		if(canBeKilledInstantly(p)){
			this.HP = 0 ;
			return ;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG));
										   
		
			p.decreaseHP(field_increased_dmg +
					Percent.getPercent(PYROMANCER_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			p.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(PYROMANCER_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE));
		
		}
		
	}
	
	public void execute(Knight k ,int field){
		
		
		if(canBeKilledInstantly(k)){
			this.HP = 0 ;
			return ;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG));
										   
		
			k.decreaseHP(field_increased_dmg +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			k.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE));
		
		}
		
	}

	public void execute(Wizard w ,int field){
		
		if(canBeKilledInstantly(w)){
			this.HP = 0 ;
			return ;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG));
										   
		
			w.decreaseHP(field_increased_dmg +
					Percent.getPercent(WIZARD_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			w.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(WIZARD_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE));
		
		}

		
		
	}

	public void execute(Rogue r ,int field){
		
		if(canBeKilledInstantly(r)){
			this.HP = 0 ;
			return ;
		}
		
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = EXECUTE_BASE_DMG +
								   (level * EXECUTE_LVL_INCREASE)+
								   Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG + (level * EXECUTE_BASE_DMG));
										   
		
			r.decreaseHP(field_increased_dmg +
					Percent.getPercent(ROGUE_EXECUTE_DMG_INCREASE, field_increased_dmg)+
					(level * EXECUTE_LVL_INCREASE));
		
		}
		
		else if(!has_field_advantage){
			
		
			r.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(ROGUE_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(level * EXECUTE_LVL_INCREASE));
		
		}

		
		
		
	}

	
	public void slam(Pyromancer p ,int field){
		
	}
	
	public void slam(Knight k ,int field){
		
		if(isDead())
			return ;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG);
			
			k.decreaseHP(field_increased_dmg +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			k.decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE));
			
		}
		
		
	}
	
	public void slam(Wizard w ,int field){
		
		
		if(isDead())
			return ;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG);
			
			w.decreaseHP(field_increased_dmg +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			w.decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE));
			
		}
		
	}

	public void slam(Rogue r ,int field){
		
		if(isDead())
			return ;
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_dmg = SLAM_BASE_DMG + (level * SLAM_LVL_INCREASE)+
									  Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG);
			
			r.decreaseHP(field_increased_dmg +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, field_increased_dmg)+
					(level * SLAM_LVL_INCREASE));
			
		}
		
		else if(!has_field_advantage){
			
			
			r.decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(level * SLAM_LVL_INCREASE));
			
		}
		
	}
	
	
	private boolean checkField(int field){
		return field == Field.LAND;
	}
	
	
	public boolean canBeKilledInstantly(Hero h){
		
		int coefficient = h.level * 1;
		if(coefficient > 20)
			coefficient = 20 ;
		
		if(this.HP < Percent.getPercent(coefficient, this.maxHP))
			return true ;
		
		return false ;
	}
	
	
}
