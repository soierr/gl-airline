/**
 * 
 */
package gl.airline.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Sergey Slipchenko
 *
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class Aircraft implements Comparable<Object>{
	
	/*ECONOMY - this is a type (i.e class but we don't use class as it's reserved word in Java)
	 *          of the airplane with the biggest capacity of passengers,
	 *          it's not that effective as to how many fuel is consumed per hour
	 *          and it doesn't have that much business features like: media entertainment box, alcohol menu during the flight, etc
	 *          This is in general how we build our hierarchy from ECONOMY to PREMIUM
	 *          P.S. We consider an aircraft as a public aviation airplane which supposed to transfer passengers.*/	
	public static enum TYPE{
		
		ECONOMY,
		BUSINESS,
		PREMIUM
	}
	
	public abstract int getCode();
	
	public abstract int getCapacityTotal();
	
	public abstract int getCapacityCarrying();
	
	public abstract int getFlightRange();
	
	public abstract int getConsumptionFuel();
	
	public abstract TYPE getType();

}
