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
	
	private boolean has_field_advantage = false;
	
	private int instant_kill_limit;
	
	
	public Knight(){
		this.XP = 0;
		this.HP = 900;
		this.maxHP = 900;
		this.instant_kill_limit = 20 ;
		
	}
	
	public void execute(Pyromancer p, int field){
		
	}
	
	public void execute(Knight k ,int field){
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			k.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG)+
					(level * EXECUTE_LVL_INCREASE)+
					Percent.getPercent(FIELD_DMG_INCREASE,EXECUTE_BASE_DMG));
		
		
			decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(k.level * EXECUTE_LVL_INCREASE)+
					Percent.getPercent(FIELD_DMG_INCREASE, EXECUTE_BASE_DMG));
		
		}
		
		else if(!has_field_advantage){
			
			k.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG)+
					(level * EXECUTE_LVL_INCREASE));
		
		
			decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
					(k.level * EXECUTE_LVL_INCREASE));
		
		}
		
	}

	public void execute(Wizard w ,int field){
		
	}

	public void execute(Rogue r ,int field){
		
	}

	
	public void slam(Pyromancer p ,int field){
		
	}
	
	public void slam(Knight k ,int field){
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
		
			k.decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG)+
					(level * SLAM_LVL_INCREASE)+
					Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG));
		
			
			decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(k.level * SLAM_LVL_INCREASE)+
					Percent.getPercent(FIELD_DMG_INCREASE, SLAM_BASE_DMG));
			
		}
		
		else if(!has_field_advantage){
			
		
			k.decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG)+
					(level * SLAM_LVL_INCREASE));
		
			
			decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
					(k.level * SLAM_LVL_INCREASE));
			
		}
		
		
	}
	
	public void slam(Wizard w ,int field){
		
	}

	public void slam(Rogue r ,int field){
		
	}
	
	
	private boolean checkField(int field){
		return field == Field.LAND;
	}
}
