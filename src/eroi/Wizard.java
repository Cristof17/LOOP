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
	
	private float procent ;
	
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
		
		float dmg_fireblast = p.fireblast(this, field);
		float dmg_ignite = p.ignite(this, field);
		
		this.drain(p, field);
		int dmg = Math.round(dmg_fireblast +dmg_ignite ); 
		this.deflect(p, field,dmg);
		
	}
	
	public void fightsWith(Wizard w , int field , int round){
		
		this.drain(w, field);
		
		w.drain(this, field);
		
	}
	
	public void fightsWith(Rogue r , int field , int round){
		
	}
	
	
	public float drain(Pyromancer p , int field){
	
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + PYROMANCER_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * p.maxHP, p.HP))));
			
			
			p.decreaseHP(damage);
			
			int procent_without_rase = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * p.maxHP, p.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_rase * Math.min(0.3 * p.maxHP, p.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + PYROMANCER_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * p.maxHP, p.HP)));
			
			
			p.decreaseHP(damage); 
			
			int procent_without_rase = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * p.maxHP, p.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
		
	}
	
	public float drain(Knight k , int field){
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + KNIGHT_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * k.maxHP, k.HP))));
			
			
			k.decreaseHP(damage);
			
			int procent_without_rase = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * k.maxHP, k.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_rase * Math.min(0.3 * k.maxHP, k.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + KNIGHT_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * k.maxHP, k.HP)));
			
			
			k.decreaseHP(damage); 
			
			int procent_without_rase = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * k.maxHP, k.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
	}	
	
	public float drain(Wizard w , int field){
	
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + WIZARD_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * w.maxHP, w.HP))));
			
			
			w.decreaseHP(damage);
			
			int procent_without_rase = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * w.maxHP, w.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_rase * Math.min(0.3 * w.maxHP, w.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + WIZARD_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * w.maxHP, w.HP)));
			
			
			w.decreaseHP(damage); 
			
			int procent_without_rase = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * w.maxHP, w.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
		
	}
	
	
	public float drain(Rogue r , int field){
		
		int damage_done_this_fight = 0; 
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
		
			procent = Percent.getPercent(100 + ROGUE_DRAIN_DMG_INCREASE ,20 + (level * 5));
			procent = Percent.getPercent(110, procent);
			
			int damage =Math.round( Percent.getPercent(procent ,(float)( Math.min(0.3 * r.maxHP, r.HP))));
			
			
			r.decreaseHP(damage);
			
			int procent_without_rase = 20 + (level * 5) +(int) (0.1 * (20 + (level * 5)));
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * r.maxHP, r.HP)+
										  Percent.getPercent(FIELD_DAMAGE_INCREASE,(int)( procent_without_rase * Math.min(0.3 * r.maxHP, r.HP)))));
			
		}
		
		else if(!has_field_advantage){
			
			procent = Percent.getPercent(100 + ROGUE_DRAIN_DMG_INCREASE , 20 + (level * PROCENT_INCREASE));
			
			int damage = (int) Math.round(Percent.getPercent(procent ,(int) Math.min(0.3 * r.maxHP, r.HP)));
			
			
			r.decreaseHP(damage); 
			
			int procent_without_rase = 20 + (level * PROCENT_INCREASE);
			damage_done_this_fight =Math.round( Percent.getPercent(procent_without_rase ,(int) Math.min(0.3 * r.maxHP, r.HP)));
		
		}
		
		return damage_done_this_fight; 
		
		
		
	}
	
	
	public float deflect(Pyromancer p ,int field ,int damage_taken){
		
		int damage_done_this_fight = 0;
		int damage_percent = 0 ;
		
		if(35 + (level * 2) > 70){
			damage_percent = 70;
		}else{
			damage_percent = 35 + (level * 2);
		}
		
		has_field_advantage = checkField(field);
		
		if(has_field_advantage){
			
			int damage_without_rase = Math.round(Percent.getPercent( Percent.getPercent(110, damage_percent), damage_taken));
			
			int damage_with_rase =Math.round( damage_without_rase + Percent.getPercent(PYROMANCER_DEFLECT_DMG_INCREASE , damage_without_rase)); 
			
			p.decreaseHP(damage_with_rase);
			
			damage_done_this_fight =Math.round(damage_without_rase + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_without_rase));
			
		}
		else if(!has_field_advantage){
			
			int damage_without_rase =Math.round( Percent.getPercent(damage_percent, damage_taken));
		
			float dmg  = Percent.getPercent (35 + (Percent.getPercent(PYROMANCER_DEFLECT_DMG_INCREASE, 35)) ,damage_taken);
			
			p.decreaseHP((int)dmg); //it works only by casting to int not using Math.round()
			
			
			damage_done_this_fight = damage_without_rase;
		}
		
		return damage_done_this_fight;
		
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
			
			int damage_without_rase = Math.round(Percent.getPercent( Percent.getPercent(110, damage_percent), damage_taken));
			
			int damage_with_rase =Math.round( damage_without_rase + Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE , damage_without_rase)); 
			
			k.decreaseHP(damage_with_rase);
			
			damage_done_this_fight =Math.round(damage_without_rase + Percent.getPercent(FIELD_DAMAGE_INCREASE, damage_without_rase));
			
		}
		else if(!has_field_advantage){
			
			int damage_without_rase =Math.round( Percent.getPercent(damage_percent, damage_taken));
			
			k.decreaseHP(damage_without_rase + Math.round( Percent.getPercent(KNIGHT_DEFLECT_DMG_INCREASE, damage_without_rase)));
			
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
