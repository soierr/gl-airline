/**
 * 
 */
package gl.airline.output;

/**
 * @author Sergey Slipchenko
 *
 */
/*Interface holds all the common commands which you might need 
 * in order informatively prompt user via console output or any other while 
 * he works with the application*/
public interface OutputSpaceInt {
	
	public void printHello();
	
	public void printHelp();
	
	public void printSuccessOperation();
	
	public void printNotEnoughPars();
	
	public void printGoodbye();

}
