/**
 * 
 */
package gl.airline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Slipchenko
 *
 */
/*This is a class which implements all the common method for the airplane in company*/
/*Then any different airplane can have their own features, thus we implement 3 level 
 * hierarchy mentioned in the requirements. I.e Aircraft --> AircraftImpl --> Aircraft(Economy,Business,Premium, etc)*/

public class AircraftImpl extends Aircraft implements Comparable<Object>{
	
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
	
	/**
	 * 
	 */	
	public AircraftImpl(@JsonProperty("code") int code,
					@JsonProperty("capacityTotal") int capacityTotal,
					@JsonProperty("capacityCarrying") int capacityCarrying,
					@JsonProperty("flightRange") int flightRange,
					@JsonProperty("consumptionFuel") int consumptionFuel) {
		
		this.code = code;
		this.capacityTotal = capacityTotal;
		this.capacityCarrying = capacityCarrying;
		this.flightRange = flightRange;
		this.consumptionFuel = consumptionFuel;
		
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
		
		try{
			throw new NoSuchMethodException("Need to override it");
		}catch(NoSuchMethodException nsme){
			
			nsme.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public int compareTo(Object o) {
		
		AircraftImpl aircraft = null;
		
		if(!(o instanceof AircraftImpl) || o == null){
			
			throw new IllegalArgumentException("Input object is not an Aircraft or null");
			
		}else{
			aircraft = (AircraftImpl)o;
		}
		
		if(this.flightRange == aircraft.flightRange){
			return Integer.compare(this.code, aircraft.getCode());
		}else{
			return Integer.compare(this.flightRange, aircraft.getFlightRange());
		}
		
		
	}

	@Override
	public boolean equals(Object o) {
		
		AircraftImpl aircraft = null;
		
		if(!(o instanceof AircraftImpl) || o == null){
			
			throw new IllegalArgumentException("Input object is not an Aircraft or null");
			
		}else{
			
			aircraft = (AircraftImpl)o;
		}
		
		return this.code == aircraft.getCode();
	}

	@Override
	public int hashCode() {

		return super.hashCode() + this.code;
	}

}
