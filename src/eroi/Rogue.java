package eroi;


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
	
	public static final int FIELD_INCREASED_DMG = 50 ;
	
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
	
	
	public void isDamagedBy(Pyromancer h , int field , int round ){
		
	}
	
	public void isDamagedBy(Wizard w ,int field ,int round ){
		
	}
	
	public void isDamagedBy(Knight k , int field ,int round ){
		
	}
	
	public void isDamagedBy(Rogue r ,int field ,int round){
		
	}

	
	
	public void backstab(Pyromancer p , int field){
		
	}
	
	public void backstab(Knight k , int field){
		
	}
	
	public void backstab(Wizard w , int field){
		
	}
	
	public void backstab(Rogue r , int field ){
		
	}
	
	
	
	
	
	public void paralysis(Pyromancer p , int field){
		
	}
	
	public void paralysis(Knight k , int field){
		
	}

	public void paralysis(Wizard w , int field){
		
	}

	public void paralysis(Rogue r , int field){
		
	}

}
