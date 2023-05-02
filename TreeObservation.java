import java.util.Date;


public class TreeObservation implements TreeObservationInterface {

	private int treeID;
	private String date;
	private double latitude;
	private double longitude;
	private double treeCircumference;
	private Date dated;
	private double answer;

	
	// constructor that creates a TreeObservation object 
	public TreeObservation(int t, String da, double lat, double lon, double tc, Date d) {
        treeID = t;	
		date = da;
		latitude = lat;
		longitude = lon;
		treeCircumference = tc;
		dated = d;
	}
	
	public int getTreeID() {
	return treeID;
	}
	public String returndDate() {
		return date;
	}
	public double getTreeCircum() {
		return treeCircumference;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	/**
	 * Returns the date of the observation
	 * 
	 * @return a Date object that represents the date of this observation
	 */
	
	public Date getDate() {
		return dated;
	}
	/**
	 * Computes the greater circle distance between this and the given TreeObservation object
	 * 
	 * @param anotherTreeObservation a TreeObservation object to which to compute the distance from this object
	 * @throws RuntimeException if this object or the given TreeObservation object does not have latitude or longitude.
	 */

	public double computeDistance(TreeObservation anotherTreeObservation) throws RuntimeException{
//		
		 answer = (Math.acos(  ((Math.sin(Math.toRadians(this.getLatitude()))) *  (Math.sin(Math.toRadians(anotherTreeObservation.getLatitude())))
				+ (Math.cos(Math.toRadians(this.getLatitude()))) *  (Math.cos(Math.toRadians(anotherTreeObservation.getLatitude()))) 
				* (Math.cos(Math.toRadians(this.getLongitude()-anotherTreeObservation.getLongitude())))))) * 6371;
		 
		 answer = Math.round(answer*100.0)/100.0;
		return answer;
		
		
	}
}
	