package Train_Ticket;

/*
 * This class stores all data regarding a single train. 
 * Details of all trains are stored in a database
 */

public class Train 
{
	private int trainNo;
	private String trainName, source, destination;
	private double ticketPrice;
	
	
	/*
	 * Constructor
	 */
	public Train(int trainNo, String trainName, String source, String destination,  double ticketPrice) {
		super();
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.trainNo = trainNo;
		this.ticketPrice = ticketPrice;
	}
	
	/*
	 * Getters/Setters
	 */
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	

}
