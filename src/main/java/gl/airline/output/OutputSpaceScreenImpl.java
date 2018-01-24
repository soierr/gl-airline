/**
 * 
 */
package gl.airline.output;

import java.util.SortedSet;

import org.apache.commons.lang3.StringUtils;

import gl.airline.model.Aircraft;

/**
 * @author Sergey Slipchenko
 *
 */
public class OutputSpaceScreenImpl implements OutputSpaceScreenInt{
	
	private String companyName = null;
	
	private String lineHello = "******************************************************************************************";
	private String lineTable = "------------------------------------------------------------------------------------------------";
	
	public OutputSpaceScreenImpl(String companyName) {
		
		this.companyName = companyName;
	}
	
	private String getCompanyName(){
		
		return this.companyName;
	}
	
	@Override
	public void printHello() {
		
		System.out.println(lineHello);
		System.out.print("\n");
		System.out.printf("%s%n", StringUtils.center(getCompanyName() + " Airline Application", lineHello.length()));
		System.out.print("\n");
		System.out.printf("%s%n", StringUtils.center("This application is meant to help you with managing of the airplanes which company possess", lineHello.length()));
		System.out.print("\n");
		System.out.println(lineHello);
	}

	@Override
	public void printHelp() {
		
		System.out.println("Command list:");
		System.out.println(OutputSpaceScreenInt.COMMAND.CAPACITY.toString() 
				+ " - returns two sums for both total and carrying capacities of all airplanes in the company");
		System.out.println(OutputSpaceScreenInt.COMMAND.LIST.toString() 
				+ " -  lists airplanes of the company sorted by flight range in ascending order");
		System.out.println(OutputSpaceScreenInt.COMMAND.FIND.toString() 
				+ " -  lists found airplanes corresponded to a given range of fuel consumption parameters");
		System.out.println("Usage example: find $minCosumption $maxConsumption");
		//TODO exit, add, remove
		
	}
	

	@Override
	public void printCapacity(int capacityTotal, int capacityCarry, int totalAirplaneCount) {
		
		System.out.println("Total capacity: " + capacityTotal + " Carrying capacity: " 
		+ capacityCarry + " Records processed: " + totalAirplaneCount);
		
	}

	@Override
	public void printList(SortedSet<Aircraft> sortedSetAircraft) {
		
		printSet(sortedSetAircraft);
	}

	@Override
	public void printFind(SortedSet<Aircraft> sortedSetAircraft) {
		
		printSet(sortedSetAircraft);		
	}
	
	private void printSet(SortedSet<Aircraft> sortedSetAircraft){
		
		//TODO Make sure you have the console screen setup with proper width (add to documentation)
		/*System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("| Code |Total capacity, kg|Carrying capacity, kg|Flight range, km|Fuel consumption, lph|");		
		System.out.println("----------------------------------------------------------------------------------------");*/
		
		System.out.println(lineTable);
		System.out.printf("\n");
		System.out.printf("|%s|%s|%s|%s|%s|%n",
				StringUtils.center("Code", 7),
				StringUtils.center("Total capacity, kg", 20),
				StringUtils.center("Carrying capacity, kg", 23),
				StringUtils.center("Flight range, km", 18),
				StringUtils.center("Fuel consumption, lph", 23));
		System.out.printf("\n");
		System.out.println(lineTable);
		
		for(Aircraft aircraft : sortedSetAircraft){
			
			System.out.printf("|%s|%s|%s|%s|%s|%n",
					StringUtils.center(String.valueOf(aircraft.getCode()), 7),
					StringUtils.center(String.valueOf(aircraft.getCapacityTotal()), 20),
					StringUtils.center(String.valueOf(aircraft.getCapacityCarrying()), 23),
					StringUtils.center(String.valueOf(aircraft.getFlightRange()), 18),
					StringUtils.center(String.valueOf(aircraft.getConsumptionFuel()), 23));
			
		}
		
		System.out.println(lineTable);
	}

	@Override
	public void printGoodbye() {
		
		System.out.println("Application closed. See you soon.");
	}
	
	

}
