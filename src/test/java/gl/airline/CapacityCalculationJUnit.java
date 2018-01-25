/**
 * 
 */
package gl.airline;

import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import gl.airline.logic.impl.AirlineCompanyMAU;
import gl.airline.model.Aircraft;
import gl.airline.model.AircraftEconomy;

/**
 * @author SOIERR
 *
 */
public class CapacityCalculationJUnit {

	int capacityTotalCommon = 0;
	int capacityCarryingCommon = 0;
	
	AirlineCompanyMAU airlineCompanyMAU = null;
	
	@Before
	public void preparingData(){
		
		int code = 0;
		int capacityTotal = 0;
		int capacityCarrying = 0;
		int flightRange = 0;
		int fuelConsumption = 0;
		
		code = 1; 
		capacityTotal = 1000; 
		capacityCarrying = 800; 
		flightRange = 150; 
		fuelConsumption = 600;
		
		capacityTotalCommon = capacityTotalCommon + capacityTotal;
		capacityCarryingCommon = capacityCarryingCommon + capacityCarrying;
				
		Aircraft aircraftEconomy = new AircraftEconomy(code, capacityTotal, capacityCarrying,
				flightRange, fuelConsumption, Aircraft.TYPE.ECONOMY);
		
		code = 2; 
		capacityTotal = 1000; 
		capacityCarrying = 800; 
		flightRange = 160; 
		fuelConsumption = 600;
		
		capacityTotalCommon = capacityTotalCommon + capacityTotal;
		capacityCarryingCommon = capacityCarryingCommon + capacityCarrying;
		
		Aircraft aircraftBusiness = new AircraftEconomy(code, capacityTotal, capacityCarrying,  
				   flightRange, fuelConsumption, Aircraft.TYPE.BUSINESS);
		
		
		code = 3; 
		capacityTotal = 1000; 
		capacityCarrying = 800; 
		flightRange = 170; 
		fuelConsumption = 600;
		
		capacityTotalCommon = capacityTotalCommon + capacityTotal;
		capacityCarryingCommon = capacityCarryingCommon + capacityCarrying;
		
		Aircraft aircraftPremium = new AircraftEconomy(code, capacityTotal, capacityCarrying,  
				   flightRange, fuelConsumption, Aircraft.TYPE.PREMIUM);
		
		SortedSet<Aircraft> sortedSetAircrafts = new TreeSet<>();
		
		sortedSetAircrafts.add(aircraftEconomy);
		sortedSetAircrafts.add(aircraftBusiness);
		sortedSetAircrafts.add(aircraftPremium);
			
		airlineCompanyMAU = AirlineCompanyMAU.INSTANCE();
		
		airlineCompanyMAU.setAircraftSortedSet(sortedSetAircrafts);
		
	}
	
	@Test
	public void capacityCalculation(){
		
		int resultCapacityTotalCommon = airlineCompanyMAU.getManager().getCapacityTotal();
		int resultCapacityCarryingCommon = airlineCompanyMAU.getManager().getCapacityCarrying();
		
		assertEquals(capacityTotalCommon, resultCapacityTotalCommon);
		assertEquals(capacityCarryingCommon, resultCapacityCarryingCommon);
	}

}
