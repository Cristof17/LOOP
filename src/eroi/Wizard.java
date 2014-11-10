package eroi;

import javax.swing.text.html.MinimalHTMLWriter;

import Calculus.Percent;
import field.Field;

public class Wizard extends Hero {

	public static final int HP_INCREMENT = 30;
	
	public static final int PYROMANCER_DRAIN_DMG_INCREASE = -10;
	public static final int KNIGHT_DRAIN_DMG_INCREASE = 20;
	public static final int WIZARD_DRAIN_DMG_INCREASE = 5;
	public static final int ROGUE_DRAIN_DMG_INCREASE = -20;
	
	public static final int PYROMANCER_DEFLECT_DMG_INCREASE = 30;
	public static final int KNIGHT_DEFLECT_DMG_INCREASE = 40;
	public static final int WIZARD_DEFLECT_DMG_INCREASE = Integer.MAX_VALUE;
	public static final int ROGUE_DEFLECT_DMG_INCREASE = 20;
	
	public static final int FIELD_DAMAGE_INCREASE = 10 ;
	
	public static final int PROCENT_INCREASE = 5;
	
	public static final int DEFLECT_DMG_PROCENT = 35;
	public static final int DEFLECT_DMG_PROCENT_INCREASE = 2;
	public static final int DEFLECT_DMG_PROCENT_MAXIMUM = 70 ;
	
	private boolean has_field_advantage = false ;
	
	private int procent ;
	
	public Wizard(){
		this.XP = 0;
		this.HP = 400;
		this.maxHP = 400;
		this.procent = 20;
		
	}
	
	public void fightsWith(Knight k , int field , int round){
	
		int damage_taken_by_execute_without_ = k.execute(this, field);
		int damage_taken_by_slam_without_ = k.slam(this, field);
		
		this.drain(k,field);
		this.deflect(k, field,damage_taken_by_execute_without_ +
							  damage_taken_by_slam_without_);
		
	}
	
	
	public void fightsWith(Pyromancer p , int field , int round){
		
	}
	
	public void fightsWith(Wizard w , int field , int round){
		
	}
	
	public void fightsWith(Rogue r , int field , int round){
		
	}
	
	
	public void drain(Pyromancer p , int field){
	
		
	}
	
	public int drain(Knight k , int field){
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + KNIGHT_DRAIN_DMG_INCREASE , 20 + (level * 5));
			
			int damage = Percent.getPercent(procent ,(int)( Math.min(0.3 * k.maxHP, k.HP)));
			
			
			k.decreaseHP(damage + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage));
			
			int procent_without_rase = 20 + (level * 5);
			damage_done_this_fight =Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * k.maxHP, k.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_rase * Math.min(0.3 * k.maxHP, k.HP))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + KNIGHT_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * k.maxHP, k.HP)));
			
			
			k.decreaseHP(damage); 
			
			int procent_without_rase = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * k.maxHP, k.HP));
		
		}
		
		return damage_done_this_fight; 
		
		
	}	
	
	public void drain(Wizard w , int field){
		
	}
	
	public void drain(Rogue r , int field){
		
	}
	
	
	public void deflect(Pyromancer p ,int field ,int damage_taken){
		
	}

	public int deflect(Knight k , int field , int damage_taken){
		
		int damage_done_this_fight = 0;
		int damage_percent = 0 ;
		
		if(35 + (level * 2) > 70){
			damage_percent = 70;
		}else{
			damage_percent = 35 + (level * 2);
		}
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int damage_without_rase = Percent.getPercent(damage_percent, damage_taken);
			
			int damage_with_rase = damage_without_rase + 
									Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE, damage_without_rase); 
			
			k.decreaseHP(damage_with_rase + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_with_rase));
			
			damage_done_this_fight = damage_without_rase +
					                 Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_without_rase);
			
		}
		else if(!has_field_advantage){
			
			int damage_without_rase = Percent.getPercent(damage_percent, damage_taken);
			
			k.decreaseHP(damage_without_rase + Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE, damage_without_rase));
			
			damage_done_this_fight = damage_without_rase;
		}
		
		return damage_done_this_fight;
	}
	
	public void deflect(Wizard w , int field ,int damage_taken){
		
	}
	
	public void deflect(Rogue r ,int field ,int damage_taken){
		
	}
	
	private boolean checkField(int field){
		return field == Field.DESERT;
	}
	
}
