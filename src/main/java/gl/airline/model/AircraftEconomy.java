/**
 * 
 */
package gl.airline.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Slipchenko
 *
 */
public class AircraftEconomy extends AircraftImpl{
	
	@JsonProperty
	private TYPE type;
	
	@JsonCreator
	public AircraftEconomy(@JsonProperty("code") int code,
						   @JsonProperty("capacityTotal") int capacityTotal,
						   @JsonProperty("capacityCarrying") int capacityCarrying,
						   @JsonProperty("flightRange") int flightRange,
						   @JsonProperty("consumptionFuel") int consumptionFuel,
						   @JsonProperty("type") TYPE type) {
		
		super(code, capacityTotal, capacityCarrying, flightRange, consumptionFuel);
		
		this.type = type;
	}
	
	@Override
	public TYPE getType(){
		
		return this.type;
	}

}
