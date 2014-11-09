package eroi;

public class Wizard extends Hero {

	private static final int HP_INCREMENT = 30;
	
	private static final int PYROMANCER_DRAIN_DMG_INCREASE = 20;
	private static final int KNIGHT_DRAIN_DMG_INCREASE = 20;
	private static final int WIZARD_DRAIN_DMG_INCREASE = 20;
	private static final int ROGUE_DRAIN_DMG_INCREASE = 20;
	
	private static final int PYROMANCER_DEFLECT_DMG_INCREASE = 20;
	private static final int KNIGHT_DRAIN_DEFLECT_INCREASE = 20;
	private static final int WIZARD_DRAIN_DEFLECT_INCREASE = 20;
	private static final int ROGUE_DRAIN_DEFLECT_INCREASE = 20;
	
	public Wizard(){
		this.XP = 0;
		this.HP = 400;
		
	}
	
	
	public void drain(Hero h){
		
	}
	
	
	public void deflect(Hero h){
		
	}
	
}
