/**
 * 
 */
package gl.airline.output;

import java.util.SortedSet;

import gl.airline.model.Aircraft;

/**
 * @author Sergey Slipchenko
 *
 */
/*Interface for a proper airline and output. 
 * Potentially there are may be more than one airline with different set of logics*/
public interface OutputSpaceScreenInt extends OutputSpaceInt{
	
	public static enum COMMAND{
		
		CAPACITY("capacity"),
		LIST("list"),
		FIND("find"),
		ADD("add"),
		REMOVE("remove"),
		HELP("help"),
		EXIT("exit");
		
		private final String str;
		
		private COMMAND(String str){
			
			this.str = str;
		}
		
		public String toString(){
			
			return this.str;
		}
		
	}
	
	public void printCapacity(int capacityTotal, int capacityCarry, int totalAirplaneCount);
	
	public void printList(SortedSet<Aircraft> sortedSetAircraft);
	
	public void printFind(SortedSet<Aircraft> sortedSetAircraft);

}
