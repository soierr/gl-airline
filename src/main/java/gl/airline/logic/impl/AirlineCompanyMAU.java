/**
 * 
 */
package gl.airline.logic.impl;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import gl.airline.model.Aircraft;
import gl.airline.model.AircraftBusiness;
import gl.airline.model.AircraftEconomy;
import gl.airline.model.AircraftPremium;
import gl.airline.model.AirlineCompany;
import gl.airline.utils.UtilsCommon;

/**
 * @author Sergey Slipchenko
 *
 */
public class AirlineCompanyMAU extends AirlineCompany{
	
	final int CLASS_AIRPLANE_ECONOMY = 1;
	
	final int CLASS_AIRPLANE_BUSINESS = 2;
	
	final int CLASS_AIRPLANE_PREMIUM = 3;
	
	@JsonProperty
	private static AirlineCompanyMAU airlineCompanyMAU = null;
	
	private static ObjectMapper om = null;
	
	private static ObjectReader or = null;
	
	private static File storageFile = null;
	
	private final static String STORAGE_FILENAME = "gl-airline.txt";
		
	@JsonIgnore
	private AirlineCompany.Manager managerMAU;
	
	@JsonProperty
	private final String NAME = "MAU"; 
	
	@JsonProperty
	private SortedSet<Aircraft> aircraftSortedSet = new TreeSet<>();
	
	static{
		
		om = new ObjectMapper();
		
		storageFile = new File(STORAGE_FILENAME);
		
		or = om.readerFor(AirlineCompanyMAU.class);
		
		if(storageFile.length()!=0){
			
			try{
				airlineCompanyMAU = (AirlineCompanyMAU) or.readValue(storageFile);
			}catch(IOException e){
				
				throw new RuntimeException("Problem with opening storage file or data is incorrect");
			}
		}else{
			
			
			try{
				storageFile.createNewFile();
			}catch(IOException e){
				
				throw new RuntimeException("Problem with file creation");
			}
			
			airlineCompanyMAU = new AirlineCompanyMAU();
		}
		
	}
		
	private AirlineCompanyMAU(){
		
		this.managerMAU = new ManagerMAU();
		
	};

	@JsonIgnore
	@Override
	public String getName() {
		
		return NAME;
	}
	
	public void setAircraftSortedSet(SortedSet<Aircraft> aircraftSortedSet){
		
		this.aircraftSortedSet = aircraftSortedSet;
	}
	
	@JsonIgnore
	public AirlineCompany.Manager getManager(){
		
		return managerMAU;
	}	

	@Override
	public void shutdown() {

	}
	
	private void storeData() throws JsonMappingException, JsonGenerationException, IOException{
		
		om.writeValue(storageFile, airlineCompanyMAU);
	}
	
	
	public static AirlineCompanyMAU INSTANCE(){
		
		return airlineCompanyMAU;
	}


	private class ManagerMAU implements AirlineCompany.Manager{
		
		private SortedSet<Aircraft> sorteSetTemp = new TreeSet<>();
		
		@Override
		public SortedSet<Aircraft> getAircraftsSorted() {

			return aircraftSortedSet;
		}
		
		@Override
		public SortedSet<Aircraft> findAircrafts(int minFuel, int maxFuel) {
			
			sorteSetTemp.clear();
			
			for(Aircraft aircraft : aircraftSortedSet){
				
				if(aircraft.getConsumptionFuel()>=minFuel && aircraft.getConsumptionFuel() <= maxFuel){
					sorteSetTemp.add(aircraft);
				}
			}
			
			return sorteSetTemp;
		}
		
		@Override
		public int getCapacityCarrying() {

			int capCarrying = 0;
			
			for(Aircraft aircraft : aircraftSortedSet){
				
				capCarrying = capCarrying + aircraft.getCapacityCarrying();
				
			}
			
			return capCarrying;
		}
		
		@Override
		public int getCapacityTotal() {
			
			int capTotal = 0;
			
			for(Aircraft aircraft : aircraftSortedSet){
				
				capTotal = capTotal + aircraft.getCapacityTotal();
				
			}
			
			return capTotal;
		}
		
		@Override
		public void addAircraft(int... params) {
			
			Aircraft aircraft = null;
			
    		switch(Integer.valueOf(params[4])){
    		
				case CLASS_AIRPLANE_ECONOMY: {
					
					aircraft = new AircraftEconomy(UtilsCommon.generateCode(), 
							Integer.valueOf(params[0]), 
							Integer.valueOf(params[1]), 
							Integer.valueOf(params[2]), 
							Integer.valueOf(params[3]), 
							Aircraft.TYPE.ECONOMY);
					
					break;
					
				}case CLASS_AIRPLANE_BUSINESS: {
					
					aircraft = new AircraftBusiness(UtilsCommon.generateCode(), 
							Integer.valueOf(params[0]), 
							Integer.valueOf(params[1]), 
							Integer.valueOf(params[2]), 
							Integer.valueOf(params[3]), 
							Aircraft.TYPE.BUSINESS);
					
					break;
					
				}case CLASS_AIRPLANE_PREMIUM: {
					
					aircraft = new AircraftPremium(UtilsCommon.generateCode(), 
							Integer.valueOf(params[0]), 
							Integer.valueOf(params[1]), 
							Integer.valueOf(params[2]), 
							Integer.valueOf(params[3]), 
							Aircraft.TYPE.PREMIUM);
					
					break;
				}
    		}
    		
    		getAircraftsSorted().add(aircraft);
    		
    		
    		try{
    			storeData();
    		}catch(IOException e){
    			
    			e.printStackTrace();
    		}
    		
		}
		
		@Override
		public void removeAircraft(int code) {
			
			Iterator<Aircraft> it = getAircraftsSorted().iterator();
			
			while(it.hasNext()){
				
				if(it.next().getCode() == code){
					
					it.remove();
				}
			}
			
			try{
    			storeData();
    		}catch(IOException e){
    			
    			e.printStackTrace();
    		}
			
		}
	}

}
