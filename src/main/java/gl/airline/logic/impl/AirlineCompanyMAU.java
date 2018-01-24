/**
 * 
 */
package gl.airline.logic.impl;

import java.io.File;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import gl.airline.model.Aircraft;
import gl.airline.model.AirlineCompany;

/**
 * @author Sergey Slipchenko
 *
 */
public class AirlineCompanyMAU extends AirlineCompany{
	
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
			
			airlineCompanyMAU = new AirlineCompanyMAU();
		}
		
	}
		
	private AirlineCompanyMAU(){
		
		this.managerMAU = new ManagerMAU();
		
	};
	
	/* (non-Javadoc)
	 * @see gl.airline.model.AirlineCompany#getName()
	 */
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
	
	
/*	@Override
	public void init() throws IOException, JsonProcessingException, UnsupportedOperationException{
		
		if(om != null || or != null){
			
			throw new UnsupportedOperationException("The object already has already been initialized");
		}
		
		om = new ObjectMapper();
		
		storageFile = new File(STORAGE_FILENAME);
		
	}*/
	
	/* (non-Javadoc)
	 * @see gl.airline.model.AirlineCompany#shutdown()
	 */
	@Override
	public void shutdown() {
		
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
				
				capTotal = capTotal + aircraft.getCapacityCarrying();
				
			}
			
			return capTotal;
		}
		
		/* (non-Javadoc)
		 * @see gl.airline.model.AirlineCompany.Manager#addAircraft(gl.airline.model.Aircraft)
		 */
		@Override
		public void addAircraft(Aircraft aircraft) {
			// TODO Auto-generated method stub
			
		}
		
		/* (non-Javadoc)
		 * @see gl.airline.model.AirlineCompany.Manager#removeAircraft(java.lang.String)
		 */
		@Override
		public void removeAircraft(String code) {
			// TODO Auto-generated method stub
			
		}
	}

}
