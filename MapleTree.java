// Justin Andrea
// This is a program that uses a database of tree observations of trees around the university. The program uses this data to make 
// tree observation objects based on data from the database(trees without id numbers in the database are ignored).
// The user of the program can enter in two tree ids to find information about those trees.  This information includes
// the average circumference of the trees, the last observation of the trees, and the distance between the two trees.

import java.text.ParseException;
import java.util.Scanner;

public class MapleTree {
	
	public static void main(String[] args) throws ParseException  {
	
		
    MapleTreeDatabase maple = new MapleTreeDatabase("Fall_Maples.csv");
    
    System.out.println("Enter two tree IDs (one per line):");

    Scanner input = new Scanner(System.in);
    
    int treeOne = input.nextInt();
  
    int treeTwo = input.nextInt();
    
    // checks if the first tree entered exists in the database
    if(!maple.checkExistence(treeOne)){  
    	System.out.println("Tree ID #" + treeOne + " is not found in the database");
    }
    else {
        System.out.println("Tree ID: " +treeOne);
        
        System.out.println("Avg. Circumference: " + maple.computeAverageCircumference(treeOne) + "\"");
        
        System.out.println("Last Observation: " + maple.getLastObservation(treeOne).getDate());
    }
    
 // checks if the second tree entered exists in the database
    
     if(!maple.checkExistence(treeTwo)) {
     	System.out.println("Tree ID #" + treeTwo + " is not found in the database");
     }
     else {
         System.out.println("Tree ID: " +treeTwo);
         
         System.out.println("Avg. Circumference: " + maple.computeAverageCircumference(treeTwo) + "\"");
         
         System.out.println("Last Observation: " + maple.getLastObservation(treeTwo).getDate());
     }
  // checks if trees exist for the distance statement
     if(maple.checkExistence(treeOne) && maple.checkExistence(treeTwo)) {
        System.out.println("The distance between tree ID #" + treeOne + " and tree ID #" + treeTwo + " is " +
        		maple.getLastObservation(treeOne).computeDistance(maple.getLastObservation(treeTwo))+ " km.");
     }
     else {
    	 System.out.println(" One or more trees do not exist, distance can not be calculated.");
     }
}
}