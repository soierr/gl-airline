/**
 * 
 */
package gl.airline;

import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import gl.airline.logic.impl.AirlineCompanyMAU;
import gl.airline.model.Aircraft;
import gl.airline.model.AircraftBusiness;
import gl.airline.model.AircraftEconomy;
import gl.airline.model.AircraftPremium;

/**
 * @author Sergey Slipchenko
 *
 */
public class SortedSetSerTest {
	
	/*Just a simple test to check whether the model is serialized/deserialized ok*/
	public static void main(String[] args) {
		
		try{
		
			ObjectMapper om = new ObjectMapper();
			Aircraft aircraftEconomy = new AircraftEconomy(1, 1000, 800,  150, 600, Aircraft.TYPE.ECONOMY);
			Aircraft aircraftBusiness = new AircraftBusiness(2, 1000, 800, 160, 600, Aircraft.TYPE.BUSINESS);
			Aircraft aircraftPremium = new AircraftPremium(3, 1000, 800, 700, 170, Aircraft.TYPE.PREMIUM);
			
			SortedSet<Aircraft> sortedSetAircrafts = new TreeSet<>();
			
			sortedSetAircrafts.add(aircraftEconomy);
			sortedSetAircrafts.add(aircraftBusiness);
			sortedSetAircrafts.add(aircraftPremium);
			
			AirlineCompanyMAU airlineCompanyMAU = AirlineCompanyMAU.INSTANCE();
			
			airlineCompanyMAU.setAircraftSortedSet(sortedSetAircrafts);
			
			File resultFile = new File("gl-airline.txt");
			
			om.writeValue(resultFile, airlineCompanyMAU);
			
			ObjectReader or = om.readerFor(AirlineCompanyMAU.class);
			
			AirlineCompanyMAU airlineCompanyMAU2 = (AirlineCompanyMAU) or.readValue(resultFile);
			
			System.out.println(airlineCompanyMAU2.getName());
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}

}
