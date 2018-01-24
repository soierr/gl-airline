/**
 * 
 */
package gl.airline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Sergey Slipchenko
 *
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class Aircraft implements Comparable<Object>{
	
	@JsonProperty
	private int code;
	
	@JsonProperty
	private int capacityTotal;
	
	@JsonProperty
	private int capacityCarrying;
	
	@JsonProperty
	private int flightRange;
	
	@JsonProperty
	private int consumptionFuel;
	
	@JsonProperty
	private TYPE type;
	
	
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
	
	/**
	 * 
	 */	
	public Aircraft(@JsonProperty("code") int code,
					@JsonProperty("capacityTotal") int capacityTotal,
					@JsonProperty("capacityCarrying") int capacityCarrying,
					@JsonProperty("flightRange") int flightRange,
					@JsonProperty("consumptionFuel") int consumptionFuel,
					@JsonProperty("type") TYPE type) {
		
		this.code = code;
		this.capacityTotal = capacityTotal;
		this.capacityCarrying = capacityCarrying;
		this.flightRange = flightRange;
		this.consumptionFuel = consumptionFuel;
		this.type = type;
		
	}
	
	public int getCode(){
		
		return this.code;
	}
	
	public int getCapacityTotal(){
	
		return capacityTotal;
	}
	
	public int getCapacityCarrying(){
		
		return capacityCarrying;
	}
	
	public int getFlightRange(){
		
		return this.flightRange;
	}
	
	public int getConsumptionFuel(){
		
		return consumptionFuel;
	}
	
	public TYPE getType(){
		
		return type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		
		Aircraft aircraft = null;
		
		if(!(o instanceof Aircraft) || o == null){
			
			throw new IllegalArgumentException("Input object is not an Aircraft or null");
			
		}else{
			aircraft = (Aircraft)o;
		}
		
		if(this.flightRange == aircraft.flightRange){
			return Integer.compare(this.code, aircraft.getCode());
		}else{
			return Integer.compare(this.flightRange, aircraft.getFlightRange());
		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		
		Aircraft aircraft = null;
		
		if(!(o instanceof Aircraft) || o == null){
			
			throw new IllegalArgumentException("Input object is not an Aircraft or null");
			
		}else{
			
			aircraft = (Aircraft)o;
		}
		
		return this.code == aircraft.getCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		return super.hashCode() + this.code;
	}

}
