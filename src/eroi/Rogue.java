package eroi;

public class Rogue extends Hero{

	public static final int HP_INCREMENT = 40;
	
	public static final int PYROMANCER_BACKSTAB_DMG_INCREASE = 25;
	public static final int KNIGHT_BACKSTAB_DMG_INCREASE = -10;
	public static final int WIZARD_BACKSTAB_DMG_INCREASE = 25;
	public static final int ROGUE_BACKSTAB_DMG_INCREASE = 20;
	
	public static final int PYROMANCER_PARALYSIS_DMG_INCREASE = 20;
	public static final int KNIGHT_PARALYSIS_DMG_INCREASE = -20;
	public static final int WIZARD_PARALYSIS_DMG_INCREASE = 25;
	public static final int ROGUE_PARALYSIS_DMG_INCREASE = -10;
	
	public Rogue(){
		this.XP = 0;
		this.HP = 600;
		this.maxHP = 600;
		
	}
	
	public void backstab(Pyromancer p){
		
	}
	
	public void backstab(Knight k){
		
	}
	
	public void backstab(Wizard w){
		
	}
	
	public void backstab(Rogue r){
		
	}
	
	
	
	
	
	public void paralysis(Pyromancer p){
		
	}
	
	public void paralysis(Knight k){
		
	}

	public void paralysis(Wizard w){
		
	}

	public void paralysis(Rogue r){
		
	}

	
	
}
