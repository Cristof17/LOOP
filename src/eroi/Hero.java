package eroi;

public class Hero {
	
	public int level;
	public int XP;
	public int HP;
	
	public int increaseHP(int value ){
		return 0;
	}
	
	public int decreaseHP(int value){
		this.HP -= value ;
		return this.HP;
	}
	
	public int increaseXP(){
		return 0;
	}
	
	public int decreaseXP(){
		return 0;
	}
	
	public int increaseLevel(int value){
		return 0;
	}
	
	public int decreaseLevel(int value){
		return 0;
		
	}
	
	
	
}
