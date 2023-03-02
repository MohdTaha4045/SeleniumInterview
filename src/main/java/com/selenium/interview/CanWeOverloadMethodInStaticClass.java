package com.selenium.interview;

public class CanWeOverloadMethodInStaticClass 
{ 
	public static void main(String[] args) 
	{
		AnotherStaticClass add = new AnotherStaticClass();	
		System.out.println(add.sum(5, 5));
		System.out.println(add.sum(7.25, 2.75));
		System.out.println(add.sum(3, 4, 3));
	
	}

	public static class AnotherStaticClass 
	{
		// Yes/ we can OverLoad Methods in Static class
		
		/* We can define multiple methods with the same name
		in the static class, as long as they have different parameter
		The compiler can differentiate between the methods based on the number,
		types, and order of the arguments.
		 */
		
		public int sum(int x, int y) 
		{ 
			return (x + y); 
		}
		  
	    public int sum(int x, int y, int z)
	    {
	        return (x + y + z);
	    }
	  
	    
	    public double sum(double x, double y)
	    {
	        return (x + y);
	    } 

	}

}
