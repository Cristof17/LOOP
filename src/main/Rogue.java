package main;


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
	
	public static final int BACKSTAB_BASE_DAMAGE = 200 ;
	public static final int BACKSTAB_LVL_INCREASE = 40 ;
	
	public static final int PARALYSIS_BASE_DAMAGE = 40;
	public static final int PARALYSIS_LVL_INCREASE = 10 ;
	
	public static final int FIELD_INCREASED_DMG = 15 ;
	
	private int hit_counter = 0 ;
	
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
	
	
	public void isDamagedBy(Pyromancer p , int field , int round ){
		
		this.backstab(p, field);
		this.paralysis(p, field);
		
		p.fireblast(this, field);
		p.ignite(this, field);
	}
	
	public void isDamagedBy(Wizard w ,int field ,int round ){
		
	}
	
	public void isDamagedBy(Knight k , int field ,int round ){
		
		this.backstab(k, field);
		this.paralysis(k, field);
		
		k.execute(this, field);
		k.slam(this, field);
	}
	
	public void isDamagedBy(Rogue r ,int field ,int round){
		
	}

	
	
	public float backstab(Pyromancer p , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = this.checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_damage = Math.round(Percent.getPercent(100 + FIELD_INCREASED_DMG, BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE)));
			
			damage_done_this_fight = field_increased_damage ;
			
			if(hit_counter == 3 ){
				field_increased_damage  = Math.round(Percent.getPercent(150 , field_increased_damage));
				this.hit_counter = 0 ;
			}
			
			p.decreaseHP(Math.round(Percent.getPercent(100 + PYROMANCER_BACKSTAB_DMG_INCREASE,field_increased_damage)));
			
		}else{
			
			int damage = Math.round(BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE));
			
			p.decreaseHP(damage);
			
			damage_done_this_fight = damage ; 
		}
		
		return damage_done_this_fight ;
		
	}
	
	public float backstab(Knight k , int field){
	
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = this.checkField(field);
		
		if(has_field_advantage){
			
			int field_increased_damage = Math.round(Percent.getPercent(100 + FIELD_INCREASED_DMG, BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE)));
			
			damage_done_this_fight = field_increased_damage ;
			
			if(hit_counter == 3 ){
				field_increased_damage  = Math.round(Percent.getPercent(150 , field_increased_damage));
				this.hit_counter = 0 ;
			}
			
			k.decreaseHP(Math.round(Percent.getPercent(100 + KNIGHT_BACKSTAB_DMG_INCREASE,field_increased_damage)));
			
		}else{
			
			int damage = Math.round(BACKSTAB_BASE_DAMAGE + (level * BACKSTAB_LVL_INCREASE));
			
			k.decreaseHP(Math.round(Percent.getPercent(100 + KNIGHT_BACKSTAB_DMG_INCREASE, damage)));
			
			damage_done_this_fight = damage ; 
		}
		
		return damage_done_this_fight ;
		
	}
	
	public void backstab(Wizard w , int field){
		
	}
	
	public void backstab(Rogue r , int field ){
		
	}
	
	
	
	
	
	public float paralysis(Pyromancer p , int field){
		
		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Math.round(Percent.getPercent(100 + FIELD_INCREASED_DMG, PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_LVL_INCREASE)));
			
			p.decreaseHP(Math.round(Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE, field_increased_damage )));
			
			p.setDamageOverTime(Math.round(Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE, field_increased_damage)), 6 , true);
			
			damage_done_this_fight = field_increased_damage;
			
		}else{
			
			float damage = PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_BASE_DAMAGE);
			
			p.decreaseHP(Math.round( Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE, damage)));
			
			p.setDamageOverTime(Math.round(Percent.getPercent(100 + PYROMANCER_PARALYSIS_DMG_INCREASE , damage)), 6, true);
			
			damage_done_this_fight = damage; 
			
		}
		
		return damage_done_this_fight;
		
	}
	
	public float paralysis(Knight k , int field){

		float damage_done_this_fight = 0 ;
		
		boolean has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			float field_increased_damage = Math.round(Percent.getPercent(100 + FIELD_INCREASED_DMG, PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_LVL_INCREASE)));
			
			k.decreaseHP(Math.round(Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE, field_increased_damage )));
			
			k.setDamageOverTime(Math.round(Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE, field_increased_damage)), 6 , true);
			
			damage_done_this_fight = field_increased_damage;
			
		}else{
			
			float damage = PARALYSIS_BASE_DAMAGE + (level * PARALYSIS_BASE_DAMAGE);
			
			k.decreaseHP(Math.round( Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE, damage)));
			
			k.setDamageOverTime(Math.round(Percent.getPercent(100 + KNIGHT_PARALYSIS_DMG_INCREASE , damage)), 6, true);
			
			damage_done_this_fight = damage; 
			
		}
		
		return damage_done_this_fight;

		
	}

	public void paralysis(Wizard w , int field){
		
	}

	public void paralysis(Rogue r , int field){
		
	}
	
	private boolean checkField(int field){
		return field == Field.WOODS;
	}

}
