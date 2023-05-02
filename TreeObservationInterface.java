import java.util.Date;

	/**
	 * Interface for the TreeObservation class
	 * 
	 * @author Choong-Soo Lee
	 *
	 */
	public interface TreeObservationInterface {
		/**
		 * Returns the date of the observation
		 * 
		 * @return a Date object that represents the date of this observation
		 */
		public Date getDate();
		
		/**
		 * Computes the greater circle distance between this and the given TreeObservation object
		 * 
		 * @param anotherTreeObservation a TreeObservation object to which to compute the distance from this object
		 * @throws RuntimeException if this object or the given TreeObservation object does not have latitude or longitude.
		 */
		public double computeDistance(TreeObservation anotherTreeObservation) throws RuntimeException;	
		
	}
