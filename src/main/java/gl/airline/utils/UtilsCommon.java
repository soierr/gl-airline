package gl.airline.utils;

import java.util.Random;

public class UtilsCommon {
	
	private static StringBuilder sb = new StringBuilder();
	
	private static String randomPattern = "123456789";

	private static Random random = new Random();
	
	private UtilsCommon(){
		
	}
	
	public static int generateCode(){
		
		sb.setLength(0);
		
		char c;
		
		int max = 2;
		
		for(int i = 0; i <= max; i++){
			
			c= randomPattern.charAt(random.nextInt(randomPattern.length() - 1));
			sb.append(c);
		}
		
		return Integer.valueOf(sb.toString());
	}
	
}
