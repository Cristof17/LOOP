package eroi;

public class Wizard extends Hero {

	private static final int HP_INCREMENT = 30;
	
	private static final int PYROMANCER_DRAIN_DMG_INCREASE = -10;
	private static final int KNIGHT_DRAIN_DMG_INCREASE = 20;
	private static final int WIZARD_DRAIN_DMG_INCREASE = 5;
	private static final int ROGUE_DRAIN_DMG_INCREASE = -20;
	
	private static final int PYROMANCER_DEFLECT_DMG_INCREASE = 30;
	private static final int KNIGHT_DRAIN_DEFLECT_INCREASE = 40;
	private static final int WIZARD_DRAIN_DEFLECT_INCREASE = 20;
	private static final int ROGUE_DRAIN_DEFLECT_INCREASE = Integer.MAX_VALUE;
	
	public Wizard(){
		this.XP = 0;
		this.HP = 400;
		this.maxHP = 400;
		
	}
	
	
	public void drain(Pyromancer p){
		
	}
	
	public void drain(Knight h){
		
	}	
	
	public void drain(Wizard w){
		
	}
	
	public void drain(Rogue h){
		
	}
	
	
	public void deflect(Pyromancer p){
		
	}

	public void deflect(Knight k){
		
	}
	
	public void deflect(Wizard w){
		
	}
	
	public void deflect(Rogue r){
		
	}
	
}
