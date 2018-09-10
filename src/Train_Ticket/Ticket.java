package Train_Ticket;

import java.io.*;
import java.util.*;

public class Ticket 
{
	private int counter = 100;
	private String pnr, travelDate;
	private Train train;
	private Map<Passenger, Double> passengers;
	
	
	/*
	 * Constructor
	 */
	public Ticket(String travelDate, Train train) {
		super();
		System.out.println("Travel Date ENTERED: " + travelDate);
		setTravelDate(travelDate);
		
		setTrain(train);
		setPassengers(new TreeMap<Passenger, Double>());
		
		
	}
	
	
	/*
	 * Getters/Setters
	 */
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String tDate) {
		travelDate = tDate;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}


	public void setPassengers(TreeMap<Passenger, Double> passengers) {
		this.passengers = passengers;
	}



	
	 // Member Functions
	/*
	 * Generates PNR
	 * Returns a generates PNR
	 */
	private String generatePNR()
	{
		String reverseDate[] = getTravelDate().split("/");
		String pnr = train.getSource().charAt(0) +""+  train.getDestination().charAt(0) + "_" + reverseDate[2] + reverseDate[1] + reverseDate[0]  + "_" + counter++; 
		
		return pnr;
	}
	/*
	 * Calculates passenger fare
	 * Returns the passenger fee
	 */
	private Double calcPassengerFare(Passenger p)
	{
		Double d = new Double(100.0);
		if (p.getAge() <= 12)
			d = d/2;
		else if (p.getAge() >= 60)
			d -= d * 0.4;
		
		if (p.getGender() == 'F')
			d -= d * 0.25;
		
		return d;
	}
	
	/*
	 * Adds a passenger to treemap
	 */
	public void addPassenger(String s, int i, char c)
	{
		Passenger p = new Passenger(s,i,Character.toUpperCase(c));
		passengers.put(p, calcPassengerFare(p));
	}
	
	/*
	 * calculates total ticket price
	 */
	private double calculateTotalTicketPrice()
	{
		double total = 0.0;
		
		
		for (Map.Entry<Passenger, Double> p : passengers.entrySet())
			total += calcPassengerFare(p.getKey());
		
		return total;
	}
	
	/*
	 * !!!
	 * THE BIG ONE
	 * Creates the ticket.
	 * !!!!
	 */
	private StringBuilder generateTicket()
	{
		StringBuilder ticket = new StringBuilder();
		
		ticket.append("PNR         :" + generatePNR() + System.lineSeparator());
		ticket.append("Train no    :" + train.getTrainNo()+ System.lineSeparator());
		ticket.append("Train Name  :" + train.getTrainName() + System.lineSeparator());
		ticket.append("From        :" + train.getSource()+ System.lineSeparator());
		ticket.append("To          :" + train.getDestination()+ System.lineSeparator());
		ticket.append("Travel Date :" + getTravelDate()+ System.lineSeparator());
		ticket.append("Passengers: " + System.lineSeparator());
		ticket.append("Name              Age              Gender          Fare" + System.lineSeparator());
		
		for (Map.Entry<Passenger, Double> n : passengers.entrySet())
		{
			ticket.append(n.getKey().getName() + "                 ");
			ticket.append(n.getKey().getAge() + "                ");
			ticket.append(n.getKey().getGender() + "               ");  
			ticket.append(+ n.getValue() + System.lineSeparator());
		}
		
		ticket.append("Total Price: " + calculateTotalTicketPrice() + System.lineSeparator() + "-------------------------------------------" + System.lineSeparator());
		
		return ticket;
	}
	
	/*
	 * Write the ticket to a file
	 */
	public void writeTicket()
	{
		System.out.println(generateTicket().toString());
		
		try
		{
			//FileWriter out = new FileWriter("D:\\Eclipse Projects\\Train Application\\tickets.txt", true);
			FileWriter out = new FileWriter("src/tickets.txt", true);
			
			
			out.write(generateTicket().toString());
			
			System.out.println("Printed to File");
			out.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			
		}
		
		
		
	}
	
	
}
