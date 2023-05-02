/**
 * 
 * Interface for the MapleTreeDatabase class
 * 
 * @author Choong-Soo Lee
 *
 */
public interface MapleTreeDatabaseInterface {
	/**
	 * Looks up the most recent observation of the given tree ID
	 * 
	 * @param treeID the tree ID to look up
	 * @return TreeObservation object that contains the most recent observation for the given tree ID
	 * @throws RuntimeException if the given tree ID does not exist in the database
	 */
	public TreeObservation getLastObservation(int treeID) throws RuntimeException;
	
	
	/**
	 * Computes the average circumference for the given tree ID
	 * 
	 * @param treeID the tree ID to look up
	 * @return the average circumference of the given tree ID
	 * @throws RuntimeException if there is no circumference recorded for the given tree ID
	 */
	public double computeAverageCircumference(int treeID) throws RuntimeException;
	
}
