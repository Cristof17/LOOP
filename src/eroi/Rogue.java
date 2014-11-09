package eroi;

public class Rogue extends Hero{

	private static final int HP_INCREMENT = 40;
	
	private static final int PYROMANCER_BACKSTAB_DMG_INCREASE = 25;
	private static final int KNIGHT_BACKSTAB_DMG_INCREASE = 25;
	private static final int WIZARD_BACKSTAB_DMG_INCREASE = 25;
	private static final int ROGUE_BACKSTAB_DMG_INCREASE = 25;
	
	private static final int PYROMANCER_PARALYSIS_DMG_INCREASE = 25;
	private static final int KNIGHT_PARALYSIS_DMG_INCREASE = 25;
	private static final int WIZARD_PARALYSIS_DMG_INCREASE = 25;
	private static final int ROGUE_PARALYSIS_DMG_INCREASE = 25;
	
	public Rogue(){
		this.XP = 0;
		this.HP = 600;
		
	}
	
	public void backstab(Hero h){
		
	}
	
	
	public void paralysis(Hero h){
		
	}
	
}
