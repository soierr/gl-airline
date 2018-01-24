package gl.airline.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import gl.airline.logic.impl.AirlineCompanyMAU;
import gl.airline.model.AirlineCompany;
import gl.airline.output.OutputSpaceScreenImpl;
import gl.airline.output.OutputSpaceScreenInt;

import static gl.airline.output.OutputSpaceScreenInt.COMMAND;

/**
 * Hello world!
 *
 */
public class App{
		
    public static void main( String[] args ) throws Exception{
    	
        AirlineCompany airlineCompany = AirlineCompanyMAU.INSTANCE();
        
        AirlineCompany.Manager airlineCompanyManager = airlineCompany.getManager();
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String cmd = "";
        
        OutputSpaceScreenInt outputSpaceScreenInt = new OutputSpaceScreenImpl(airlineCompany.getName());
        
        outputSpaceScreenInt.printHello();

        while (!COMMAND.EXIT.toString().equals(cmd)) {

        	 cmd = bufferedReader.readLine();
        	 
        	 if(COMMAND.CAPACITY.toString().equals(cmd)){
        		 
        		 outputSpaceScreenInt.printCapacity(airlineCompanyManager.getCapacityTotal(), 
        				 airlineCompanyManager.getCapacityCarrying(), airlineCompanyManager.getAircraftsSorted().size());
        		 
        	 }else if(COMMAND.LIST.toString().equals(cmd)){
        		 
        		 outputSpaceScreenInt.printList(airlineCompanyManager.getAircraftsSorted());
        		 
        	 }else if(COMMAND.FIND.toString().equals(cmd)){
        		 
        		 //TODO Need to add parameters processing
        		 outputSpaceScreenInt.printFind(airlineCompanyManager.findAircrafts(0, 10));
        	 }
        	 
        }
        
        outputSpaceScreenInt.printGoodbye();
        System.exit(0);
        
    }
}
