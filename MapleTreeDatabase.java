
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

	public class MapleTreeDatabase implements MapleTreeDatabaseInterface {
		private ArrayList<TreeObservation> trees;
		
		/**
		 * Constructor that fills the array list trees with TreeObservations that are created from the Fall Maples file
		 * @param str
		 * @throws ParseException
		 */
		
		public MapleTreeDatabase(String str) throws ParseException {
			trees = new ArrayList<TreeObservation>();
		String fallFile = str;
		// default parameters for the tree observations that will be made
    	int par1 = 0; 
    	String par2 = "";
    	double par3 = 0.0;
    	double par4 = 0.0;
    	double par5 = 0.0;
    	Date par6 = null;
    	
    	String line = null;	   

    	
    	try {
    		FileReader fileReader = new FileReader(fallFile);
    		
    		BufferedReader bufferedReader = new BufferedReader(fileReader);
    		//  statement is intended to ignore first line
    	    bufferedReader.readLine();

    		while((line = bufferedReader.readLine()) != null) {

    			String[] result = line.split(",");
    			
    			//substring for date parameter to get rid of quotes and put it into correct simple date format 
             result[0] = result[0].substring(7,11) + "-" +result[0].substring(1,3) + "-" +result[0].substring(4,6);

       
    	// assignment of tree observation variables from Fall Maple data 
        // checks if the data exists
    			if(!result[1].equals("")) {
    			par1 = Integer.parseInt(result[1]);
    			}
    			else {
    			continue;
    			}
    			if(!result[2].equals("")) {
    				 par2 = (result[2]);
    			}
    			if(!result[4].equals("")) {
    				par3 = Double.parseDouble(result[4]);
    			}
    			if(!result[5].equals("")) {
    				par4 = Double.parseDouble(result[5]);
    			}
    			if(!result[9].equals("")) {
    				par5 = Double.parseDouble(result[9]);
    			}
    			if(!result[0].equals("")) {
    				DateFormat stuff = new SimpleDateFormat("yyyy-MM-dd");
    				 par6 = stuff.parse(result[0]);
    			}
    			
    			
    			
    			TreeObservation treeHolder = new TreeObservation(par1,par2,par3,par4,par5,par6);
    			trees.add(treeHolder);
    			
    			
    		}
    		
    		
    		bufferedReader.close();
     	}
   	    catch(FileNotFoundException e) {
    	System.out.println("File could not be opened");
    	}
    	catch(IOException e) {
    		System.out.println("File could not be read");
    	}
    	catch(NumberFormatException ex) {
    		System.out.println("File could not be read");
    	}
    	

		}
	
		/**
		 * Looks up the most recent observation of the given tree ID
		 * 
		 * @param treeID the tree ID to look up
		 * @return TreeObservation object that contains the most recent observation for the given tree ID
		 * @throws RuntimeException if the given tree ID does not exist in the database
		 */
		
		@Override
		public TreeObservation getLastObservation(int treeID) throws RuntimeException {

		for(int i = trees.size()-1; i > 0; i--) {
			
			if(treeID == trees.get(i).getTreeID()) {
				return trees.get(i);   
			}
		}
		
		return null;
		}
		
		/**
		 * Computes the greater circle distance between this and the given TreeObservation object
		 * 
		 * @param anotherTreeObservation a TreeObservation object to which to compute the distance from this object
		 * @throws RuntimeException if this object or the given TreeObservation object does not have latitude or longitude.
		 */
		
		public double computeAverageCircumference(int treeID) throws RuntimeException {
			double total = 0.0;
			int count = 0;
			double ans = 0.0;
			for(int i = 0; i < trees.size()-1;i++) {
				if(trees.get(i).getTreeID() == treeID) {
			
					total = total + trees.get(i).getTreeCircum();
					count++;
				}
			}
			ans = (total/count);
			ans = Math.round(ans*100.0)/100.0;
			return ans;
		} 
		/**
		 * Method that returns a boolean.  It returns true if the given tree Id matches at least one tree ID 
		 * in the database and returns false otherwise.
		 * @param treeID
		 * @return
		 */
		public boolean checkExistence(int treeID) {
			
			for(int i = 0; i < trees.size(); i++) {
				if(trees.get(i).getTreeID() == treeID ) {
					return true;
				}
			}
			return false;
		}
	    
	    
	    
	    
	}

