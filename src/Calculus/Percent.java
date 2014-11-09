package Calculus;

public class Percent {

	public static int getPercent(int percent , int from){
		float a =  ((float)percent/100)*from ;
		return Math.round(a);
	}
	
}
