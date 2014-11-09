package eroi;

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
	
	public Pyromancer(){
		this.XP = 0;
		this.maxHP = 500;
		this.HP = 500;
		
	}
	
	
	public void fireblast(Pyromancer h ,int field){
		
	}
	
	public void fireblast(Knight h ,int field){
		
	}
	
	public void fireblast(Wizard h , int field){
		
	}
	
	public void fireblast(Rogue h ,int field){
		
	}
	
	public void ignite(Pyromancer h ,int field){
		
	}

	public void ignite(Knight h ,int field){
		
	}
	
	public void ignite(Wizard h ,int field){
		
	}
	
	public void ignite(Rogue h ,int field){
		
	}
	
}

