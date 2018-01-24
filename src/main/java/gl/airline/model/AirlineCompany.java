/**
 * 
 */
package gl.airline.model;

import java.util.SortedSet;

/**
 * @author Sergey Slipchenko
 *
 */
public abstract class AirlineCompany{
	
	/*we want to know that all the preparations 
	 * are successfully done: file opened or db connected, etc*/
	//public abstract void init() throws Exception;
	
	public abstract Manager getManager();
	
	public abstract String getName();
	
	/*close any opened resources here*/
	public abstract void shutdown();
	
	public interface Manager {
		
		public SortedSet<Aircraft> findAircrafts(int minFuel, int maxFuel);
		
		public SortedSet<Aircraft> getAircraftsSorted();
		
		public void addAircraft(int... parameters);
		
		public void removeAircraft(int code);
		
		public int getCapacityTotal();
		
		public int getCapacityCarrying();		
		
	}

}
