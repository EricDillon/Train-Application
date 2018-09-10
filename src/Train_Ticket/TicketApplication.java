package Train_Ticket;

import java.text.SimpleDateFormat;
import java.util.*;

public class TicketApplication {

	static TrainDAO tData = new TrainDAO();
	public static void main(String[] args) 
	{
		String travelDate, pName;
		int trainNo, passengerCount,pAge;
		char pGendr;
		
		Scanner sc = new Scanner(System.in);
		
		//Get Info
		System.out.println("Enter Number of Train:");
		trainNo = sc.nextInt();
		Ticket tick;
		
		
		try
		{
			Train t = tData.findTrain(trainNo);
			
			System.out.println("Enter Travel Date (MM/DD/YYYY):");
			travelDate = sc.next();
			//sc.nextLine();
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			
			if (travelDate.compareTo(String.valueOf(df.format(new Date()))) < 0) 
			{
				System.out.println("Travel Date is before current date");
				
			}
			else
			{
				System.out.println("Enter Number of passengers:");
				passengerCount= sc.nextInt();
				sc.nextLine();
				
				tick = new Ticket(travelDate, t);
				
				for (int i = 0; i < passengerCount; i++)
				{
					System.out.println("Enter Passenger Name:");
					pName= sc.nextLine();
					System.out.println("Enter Passenger Age:");
					pAge = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Gender (M/F):");
					pGendr= sc.next().charAt(0);
					sc.nextLine();
					
					tick.addPassenger(pName, pAge, pGendr);
				}
				
				tick.writeTicket();
			}
			
			
			
			sc.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	


}
