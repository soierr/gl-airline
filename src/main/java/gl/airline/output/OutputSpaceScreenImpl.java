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
	
	private String lineHello = "********************************************************************************************";
	private String lineTable = "------------------------------------------------------------------------------------------------------------------";
	
	private final String ERROR_NO_RECORDS_FOUND = "\nNo records found\n";
	
	private final String ERROR_NOT_ENOUGH_PARAMETERS = "\nNot enough parameters. See help for details\n";
	
	public OutputSpaceScreenImpl(String companyName) {
		
		this.companyName = companyName;
	}
	
	private String getCompanyName(){
		
		return this.companyName;
	}
	
	@Override
	public void printHello() {
		
		System.out.print("\n");
		System.out.println(lineHello);
		System.out.print("\n");
		System.out.printf("%s%n", StringUtils.center(getCompanyName() + " Airline Application", lineHello.length()));
		System.out.print("\n");
		System.out.printf("%s%n", StringUtils.center("This application is meant to help you with managing of the airplanes which company possesses", lineHello.length()));
		System.out.print("\n");
		System.out.println(lineHello);
		System.out.print("\n");
	}

	@Override
	public void printHelp() {
		
		System.out.println("\nCommand list:\n");
		System.out.printf("%s%s%n", OutputSpaceScreenInt.COMMAND.CAPACITY.toString(), 
				" - returns two sums for both total and carrying capacities of all airplanes in the company");
		
		System.out.printf("%-8s%s%n", OutputSpaceScreenInt.COMMAND.LIST.toString(), 
				" - lists airplanes of the company sorted by flight range in ascending order");
		
		System.out.printf("%-8s%s%n", OutputSpaceScreenInt.COMMAND.FIND.toString(), 
				" - lists found airplanes corresponded to a given range of fuel consumption parameters");
		System.out.printf("%-11s%s%n", " ", "Usage format: find $minConsumption $maxConsumption");		
		System.out.printf("%-11s%s%n", " ", "All parameters are mandatory and integers");
		
		System.out.printf("%-8s%s%n", OutputSpaceScreenInt.COMMAND.ADD.toString(), 
				" - adds an airplane to the airline company");
		System.out.printf("%-11s%s%n", " ", "Usage format: add $totalCapacity $carryingCapacity $flightRange $fueldConsumption $airplaneClass");
		System.out.printf("%-11s%s%n", " ", "All parameters are mandatory and integers");
		System.out.printf("%-11s%s%n", " ", "Airplane classes available: 1 2 3 i.e (ECONOMY BUSINESS PREMIUM)");
		
		System.out.printf("%-8s%s%n", OutputSpaceScreenInt.COMMAND.REMOVE.toString(), 
				" - removes an airplane from the airline company");
		System.out.printf("%-11s%s%n", " ", "Usage format: remove $code");
		System.out.printf("%-11s%s%n", " ", "All parameters are mandatory and integers");
		
		System.out.printf("%-8s%s%n", OutputSpaceScreenInt.COMMAND.HELP.toString(),				
				" - describes commands available");
		
		System.out.printf("%-8s%s%n", OutputSpaceScreenInt.COMMAND.EXIT.toString(),
				" - stops the application");
		
		System.out.printf("\n");
	}
	

	@Override
	public void printCapacity(int capacityTotal, int capacityCarry, int totalAirplaneCount) {
		
		System.out.println("\nTotal capacity: " + capacityTotal + " Carrying capacity: " 
		+ capacityCarry + " Records processed: " + totalAirplaneCount + "\n");
		
	}

	@Override
	public void printList(SortedSet<Aircraft> sortedSetAircraft) {
		
		if(sortedSetAircraft.isEmpty()){
			
			System.out.println(ERROR_NO_RECORDS_FOUND);
			
		}else{
			
			printSet(sortedSetAircraft);
			
		}
	}

	@Override
	public void printFind(SortedSet<Aircraft> sortedSetAircraft) {
		
		if(sortedSetAircraft.isEmpty()){
			
			System.out.println(ERROR_NO_RECORDS_FOUND);
			
		}else{
			
			printSet(sortedSetAircraft);
			
		}		
	}
	
	private void printSet(SortedSet<Aircraft> sortedSetAircraft){
		
		System.out.printf("\n");
		System.out.println(lineTable);
		System.out.printf("\n");
		System.out.printf("|%s|%s|%s|%s|%s|%s|%n",
				StringUtils.center("Code", 7),
				StringUtils.center("Total capacity, kg", 20),
				StringUtils.center("Carrying capacity, kg", 23),
				StringUtils.center("Flight range, km", 18),
				StringUtils.center("Fuel consumption, lph", 23),
				StringUtils.center("Airplane Class", 16));
		System.out.printf("\n");
		System.out.println(lineTable);
		
		for(Aircraft aircraft : sortedSetAircraft){
			
			System.out.printf("|%s|%s|%s|%s|%s|%s|%n",
					StringUtils.center(String.valueOf(aircraft.getCode()), 7),
					StringUtils.center(String.valueOf(aircraft.getCapacityTotal()), 20),
					StringUtils.center(String.valueOf(aircraft.getCapacityCarrying()), 23),
					StringUtils.center(String.valueOf(aircraft.getFlightRange()), 18),
					StringUtils.center(String.valueOf(aircraft.getConsumptionFuel()), 23),
					StringUtils.center(String.valueOf(aircraft.getType()), 16));
			
		}
		
		System.out.println(lineTable);
		System.out.printf("\n");
	}

	@Override
	public void printSuccessOperation() {
		
		System.out.printf("\nSucessfully performed\n\n");
		
	}
	
	@Override
	public void printNotEnoughPars(){
		
		System.out.println(ERROR_NOT_ENOUGH_PARAMETERS);
	}

	@Override
	public void printGoodbye() {
		
		System.out.println("Application closed. See you soon.");
	}

}
