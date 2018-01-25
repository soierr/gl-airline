package gl.airline.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import gl.airline.logic.impl.AirlineCompanyMAU;
import gl.airline.model.AirlineCompany;
import gl.airline.output.OutputSpaceScreenImpl;
import gl.airline.output.OutputSpaceScreenInt;

import static gl.airline.output.OutputSpaceScreenInt.COMMAND;

/**
 * @author Sergey Slipchenko
 *
 */
public class App{
		
    public static void main(String[] args) throws Exception{
    	
    	final int COMMAND_ADD_NUMBER_PARS = 5;
    	
    	final int COMMAND_FIND_NUMBER_PARS = 2;
    			
    	final int COMMAND_REMOVE_NUMBER_PARS = 1;
    	
        AirlineCompany airlineCompany = AirlineCompanyMAU.INSTANCE();
        
        AirlineCompany.Manager airlineCompanyManager = airlineCompany.getManager();
        
        OutputSpaceScreenInt outputSpaceScreenInt = new OutputSpaceScreenImpl(airlineCompany.getName());
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String cmdLine = "";
        String cmdParams[] = new String[1];
        
        outputSpaceScreenInt.printHello();

        while (!COMMAND.EXIT.toString().equals(cmdParams[0])) { 
        	
        	Arrays.fill(cmdParams, null);

        	cmdLine = bufferedReader.readLine();
        	cmdParams = cmdLine.split(" ");

        	if(COMMAND.CAPACITY.toString().equals(cmdParams[0])){
        		 
        		 outputSpaceScreenInt.printCapacity(airlineCompanyManager.getCapacityTotal(), 
        				 airlineCompanyManager.getCapacityCarrying(), airlineCompanyManager.getAircraftsSorted().size());
        		 
        	}else if(COMMAND.LIST.toString().equals(cmdParams[0])){
        		 
        		 outputSpaceScreenInt.printList(airlineCompanyManager.getAircraftsSorted());
        		 
        	}else if(COMMAND.FIND.toString().equals(cmdParams[0])){
        		
        		if(cmdParams.length < COMMAND_FIND_NUMBER_PARS + 1){
        			
        			outputSpaceScreenInt.printNotEnoughPars();
        			
        		}else{
        		
        			outputSpaceScreenInt.printFind(airlineCompanyManager.findAircrafts(Integer.valueOf(cmdParams[1]), Integer.valueOf(cmdParams[2])));
        		}
        		 
        	}else if(COMMAND.ADD.toString().equals(cmdParams[0])){
        		
        		if(cmdParams.length < COMMAND_ADD_NUMBER_PARS + 1){
        			
        			outputSpaceScreenInt.printNotEnoughPars();
        			
        		}else{
        			
        			airlineCompanyManager.addAircraft(Integer.valueOf(cmdParams[1]),
							  Integer.valueOf(cmdParams[2]),
							  Integer.valueOf(cmdParams[3]),
							  Integer.valueOf(cmdParams[4]),
						      Integer.valueOf(cmdParams[5]));

        			outputSpaceScreenInt.printSuccessOperation();
        		}
        		
        		        		 
        	}else if(COMMAND.REMOVE.toString().equals(cmdParams[0])){
        		
        		if(cmdParams.length < COMMAND_REMOVE_NUMBER_PARS + 1){
        			
            		outputSpaceScreenInt.printNotEnoughPars();
        			
        		}else{
        			
        			airlineCompanyManager.removeAircraft(Integer.valueOf(cmdParams[1]));            		
            		outputSpaceScreenInt.printSuccessOperation();
        		}
        		 
        	}else if(COMMAND.HELP.toString().equals(cmdParams[0])){

        		 outputSpaceScreenInt.printHelp();
        		 
        	}
        	 
        }
        
        outputSpaceScreenInt.printGoodbye();
        System.exit(0);
        
    }
}
