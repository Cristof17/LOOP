package main;

/**
 * 
 * @author cristof
 *	 
 */
public class Percent {

	/**
	 * 
	 * @param percent The percent ratio
	 * @param from The number from which to get the percent
	 * @return Returns the percentage value
	 */
	public static float getPercent(float percent , float from){
		float a =  (percent/100)*from ;
		return a;
	}
	
}
