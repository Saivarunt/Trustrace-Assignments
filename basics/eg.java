import java.util.*;
public class eg{
	public static void main(String args[]){
		//System.out.println("Hello");

		if (args.length>0){
			System.out.println("Command line Arguments are: ");
			for(String arguments:args){
				System.out.println(arguments);
			}
		}
	} 
}