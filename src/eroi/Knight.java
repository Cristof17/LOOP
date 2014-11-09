package eroi;

import Calculus.Percent;

public final class Knight extends Hero{
	
	private static final int HP_INCREMENT = 80;
	
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
	
	public Knight(){
		this.XP = 0;
		this.HP = 900;
		
	}
	
	public void execute(Pyromancer p){
		
	}
	
	public void execute(Knight k){
		
		
		
		k.decreaseHP(EXECUTE_BASE_DMG +
					Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG)+
					(level * EXECUTE_LVL_INCREASE));
		
		decreaseHP(EXECUTE_BASE_DMG +
				Percent.getPercent(KNIGHT_EXECUTE_DMG_INCREASE, EXECUTE_BASE_DMG) +
				(k.level * EXECUTE_LVL_INCREASE));
		
		k.decreaseHP(SLAM_BASE_DMG +
					Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG)+
					(level * SLAM_LVL_INCREASE));
		
		decreaseHP(SLAM_BASE_DMG +
				Percent.getPercent(KNIGHT_SLAM_DMG_INCREASE, SLAM_BASE_DMG) +
				(k.level * SLAM_LVL_INCREASE));
		
	}

	public void execute(Wizard w){
		
	}

	public void execute(Rogue r){
		
	}

	
	public void slam(Pyromancer p){
		
	}
	
	public void slam(Knight k){
		
	}
	
	public void slam(Wizard w){
		
	}

	public void slam(Rogue r){
		
	}
}
