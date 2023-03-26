/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//CSC205AB #3 Christofer Paes 
// This is container method or sub routine that can be implemented and built upon to search through an array for a given value
// This is assuming that the array is not sorted. And that is why i chose the linear method instead of the binary method , but of course we can always implement a sort method before implementing a binary search method too. 
// secondly, i found this solution at https://www.geeksforgeeks.org/check-if-a-value-is-present-in-an-array-in-java/ I did have to mess with a little bit of bit, but not much.

import java.util.Scanner;  // Import the Scanner class
import java.util.Arrays; 
import java.util.stream.IntStream; 



public class Main
{
	
	
	private static int addlistAndSearch(int [] a, int b){ // setting the parameters for passing in an array and for passing an integer to use to search for
	   

     boolean test = false; // creating and initializing a boolean value to use for returning a test
        for(int e1 : a ) { // create an int called 'e1'(which is a temporary storage holder for iterating over values) and use the single colon operator as a shortcut for iterating.
 if(e1 == b)
 { // if the compared value that is passed in from the user compares to the element in the array that we re iterating over using the single colon operator
   test = true; 
    break;
    }
                                }

       // Print the result 
        System.out.println("Is " + b 
                           + " present in the array: " + test); 
                           return b; // we have to return the value from here
    } 
    
    
    
    
    
    
    	public static void main(String[] args) {
    	    
    	    
    	 // Get the array 
        int arr[] = { 5, 1, 1, 9, 7, 2, 6, 10 }; 
  
        // Get the value to be checked 
        int toCheckValue = 18; 
  
        // Print the array 
        System.out.println("Array: "
                           + Arrays.toString(arr)); 
  
        // Check if this value is 
        // present in the array or not 
        addlistAndSearch(arr, toCheckValue);
	}

}

